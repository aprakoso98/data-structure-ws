package com.structure.data.rest.mutasi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.structure.data.model.Tmsiswa;
import com.structure.data.model.Ttsiswahistory;
import com.structure.data.mutasi.view.MutasiExcelReportView;
import com.structure.data.repository.TmsiswaDao;
import com.structure.data.repository.TtsiswahistoryDao;
import com.structure.data.util.DataTablesRequest;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
@RequestMapping("/rest/mutasi")
public class MutasiRest {

	@Autowired
	private TmsiswaDao tmsiswaDao;
	@Autowired
	private TtsiswahistoryDao ttsiswahistoryDao;
	@Autowired
	private DataSource ds;

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public ModelAndView exportMutasi(@RequestParam Map<String, Object> param) {
		DataTablesRequest input = new DataTablesRequest();
		input.setSearch(param);
		List<com.structure.data.entity.MutasiSiswa> siswaDtos = new ArrayList<>();
		List<Tmsiswa> tmsiswas = new ArrayList<>();
		Map<String, Object> src = new HashMap<>();
		String searchStatus = input.getSearch().get("status") != null ? input.getSearch().get("status").toString() : "";
		String status = getStatus(searchStatus);
		if ("1".equals(status)) {
			tmsiswas = (List<Tmsiswa>) tmsiswaDao.findByStatusMutasi();
		} else {
			tmsiswas = (List<Tmsiswa>) tmsiswaDao.findByStatus(status);
		}

		for (Tmsiswa tmsiswa : tmsiswas) {
			com.structure.data.entity.MutasiSiswa studentDto = new com.structure.data.entity.MutasiSiswa();
			studentDto.setNis(tmsiswa.getId().getNis());
			studentDto.setNisn(tmsiswa.getId().getNisn());
			studentDto.setNama(tmsiswa.getNama());
			studentDto.setJenisKelamin(tmsiswa.getJenisKelamin().toString());
			studentDto.setTempatLahir(tmsiswa.getTempatLahir());
			studentDto.setAgama(tmsiswa.getAgama());
			studentDto.setAlamat(tmsiswa.getAlamat());
			studentDto.setKelas(tmsiswa.getKelas());
			studentDto.setAsalSekolah(tmsiswa.getAsalSekolah());
			studentDto.setCreatedDt(tmsiswa.getCreatedDt());
			studentDto.setModifiedDt(tmsiswa.getModifiedDt());
			studentDto.setStatus(tmsiswa.getStatus());

			siswaDtos.add(studentDto);
		}

		src.put("tx", siswaDtos);

		return new ModelAndView(new MutasiExcelReportView() {
		}, "param", src);
	}

	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> print(@RequestParam Map<String, Object> param)
			throws JRException, SQLException {
		DataTablesRequest input = new DataTablesRequest();
		input.setSearch(param);

		Map m = new HashMap();
		m.put("PLOGO", "classpath:report/dinas.png");
		m.put("PNISN", input.getSearch().get("nis").toString());
		m.put("PSEKOLAH", input.getSearch().get("sekolah").toString());

		byte[] byteFile = generateJasperPdf("Mutasi.jasper", m);
		ByteArrayResource resource = new ByteArrayResource(byteFile);

		Tmsiswa tmsiswa = tmsiswaDao.findById(input.getSearch().get("nis").toString());
		if (tmsiswa != null) {
			tmsiswa.setModifiedBy("Admin");
			tmsiswa.setModifiedDt(new Date());
			
			tmsiswaDao.save(tmsiswa);
			
			Ttsiswahistory ttsiswahistory = new Ttsiswahistory();
			ttsiswahistory.setNis(Integer.parseInt(tmsiswa.getId().getNis()));
			ttsiswahistory.setNisn(Integer.parseInt(tmsiswa.getId().getNisn()));
			ttsiswahistory.setStatus(tmsiswa.getStatus());
			ttsiswahistory.setCreatedBy("Admin");
			ttsiswahistory.setCreatedDt(new Date());
			
			ttsiswahistoryDao.save(ttsiswahistory);
			
		}

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + "Mutasi_Siswa" + ".pdf")
				.contentType(MediaType.APPLICATION_PDF).contentLength(byteFile.length).body(resource);
	}

	@RequestMapping(value = "/lomba", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> lomba(@RequestParam Map<String, Object> param)
			throws JRException, SQLException {
		DataTablesRequest input = new DataTablesRequest();
		input.setSearch(param);

		Map m = new HashMap();
		m.put("PLOMBA", input.getSearch().get("lomba").toString());
		m.put("PCABANG", input.getSearch().get("cabang").toString());
		m.put("PNIS", input.getSearch().get("nis").toString());
		m.put("PTINGKAT", "Rawamerta");

		byte[] byteFile = generateJasperPdf("Lomba.jasper", m);
		ByteArrayResource resource = new ByteArrayResource(byteFile);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + "Lap_Lomba" + ".pdf")
				.contentType(MediaType.APPLICATION_PDF).contentLength(byteFile.length).body(resource);
	}

	public byte[] generateJasperPdf(String jasperName, Map m) throws JRException, SQLException {
		Connection con = null;
		JasperPrint jasperPrint = null;
		try {
			con = ds.getConnection();
			jasperPrint = JasperFillManager.fillReport(MutasiRest.class.getResourceAsStream("/report/" + jasperName), m,
					con);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex1) {
					ex1.printStackTrace();
				}
			}
			ex.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex1) {
					ex1.printStackTrace();
				}
			}
		}

		return JasperExportManager.exportReportToPdf(jasperPrint);
	}

	private String getStatus(String status) {
		String result = "1";
		if ("2".equals(status)) {
			result = "baru";
		} else if ("3".equals(status)) {
			result = "pindahan";
		}
		return result;
	}

	/*
	 * public static void main(String[] args) { InputStream is =
	 * MutasiRest.class.getResourceAsStream("/report/test.txt");
	 * System.out.println(is); }
	 */

}
