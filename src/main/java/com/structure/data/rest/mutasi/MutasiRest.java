package com.structure.data.rest.mutasi;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.structure.data.model.Tmsiswa;
import com.structure.data.mutasi.view.MutasiExcelReportView;
import com.structure.data.repository.TmsiswaDao;
import com.structure.data.util.DataTablesRequest;

@Controller
@RequestMapping("/rest/mutasi")
public class MutasiRest {

	@Autowired
	private TmsiswaDao tmsiswaDao;

	@RequestMapping(value = "export", method = RequestMethod.GET)
	public ModelAndView exportMutasi(@RequestParam Map<String, Object> param) {
		DataTablesRequest input = new DataTablesRequest();
		List<com.structure.data.entity.MutasiSiswa> siswaDtos = new ArrayList<>();
		input.setSearch(param);
		List<Tmsiswa> tmsiswas = (List<Tmsiswa>) tmsiswaDao.findAll();

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

		Map<String, Object> src = new HashMap<>();
		src.put("tx", siswaDtos);

		return new ModelAndView(new MutasiExcelReportView() {
		}, "param", src);
	}

	/*@RequestMapping(value = "print", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> print(@RequestParam Map<String, Object> param) {
		DataTablesRequest input = new DataTablesRequest();
		input.setSearch(param);
		
		Map m = new HashMap<>();
		Map m = new HashMap();
        m.put("PIMAGEA", pathReport + "Ahmsdass051LogoAhm.jpg");
        m.put("PNO", noLetter + "/AR/FK-KET/" + month + "/" + year);
        m.put("PFAKTURNO", request.getInvoiceNo());
        m.put("PFAKTURDATE", request.getTglFaktur());
        m.put("PNAMACUST", request.getName());

		byte[] byteFile = null;
		ByteArrayResource resource = new ByteArrayResource(byteFile);

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + "Print" + ".pdf")
				.contentType(MediaType.APPLICATION_PDF).contentLength(byteFile.length).body(resource);
	}
	
	public byte[] generateJasperPdf(String jasperName, Map m) throws JRException {
        Connection con = null;
        JasperPrint jasperPrint = null;
        try {
//            con = dataSource.getConnection();
            jasperPrint = JasperFillManager.fillReport(MutasiRest.class.getResourceAsStream("/report/") + jasperName, m, con);
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

	public static void main(String[] args) {
		InputStream is = MutasiRest.class.getResourceAsStream("/report/test.txt");
		System.out.println(is);
	}*/

}
