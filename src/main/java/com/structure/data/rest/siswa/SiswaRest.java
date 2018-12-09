package com.structure.data.rest.siswa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.structure.data.model.Tmsiswa;
import com.structure.data.model.TmsiswaId;
import com.structure.data.repository.TmsiswaDao;
import com.structure.data.util.DataTablesRequest;
import com.structure.data.util.DataTablesResponse;

@Controller
@RequestMapping("/rest/siswa")
public class SiswaRest {

	@Autowired
	private TmsiswaDao tmsiswaDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody DataTablesResponse getAllSiswa() {
		DataTablesResponse response = new DataTablesResponse();
		List<String> column = new ArrayList<>();
		column.add("NIS");
		column.add("NISN");
		column.add("Nama");
		column.add("Jenis Kelamin");
		column.add("Tempat Lahir");
		column.add("Tanggal Lahir");
		column.add("Agama");
		column.add("Alamat");
		column.add("Kelas");
		column.add("Asal Sekolah");
		column.add("Status");

		List<com.structure.data.entity.Tmsiswa> studentDtos = new ArrayList<>();

		List<Tmsiswa> tmsiswas = (List<Tmsiswa>) tmsiswaDao.findAll();

		for (Tmsiswa tmsiswa : tmsiswas) {
			com.structure.data.entity.Tmsiswa studentDto = new com.structure.data.entity.Tmsiswa();
			studentDto.setNis(tmsiswa.getId().getNis());
			studentDto.setNisn(tmsiswa.getId().getNisn());
			studentDto.setNama(tmsiswa.getNama());
			studentDto.setJenisKelamin(tmsiswa.getJenisKelamin());
			studentDto.setTempatLahir(tmsiswa.getTempatLahir());
			studentDto.setTglLahir(tmsiswa.getTglLahir());
			studentDto.setAgama(tmsiswa.getAgama());
			studentDto.setAlamat(tmsiswa.getAlamat());
			studentDto.setKelas(tmsiswa.getKelas());
			studentDto.setAsalSekolah(tmsiswa.getAsalSekolah());
			studentDto.setStatus(tmsiswa.getStatus());

			studentDtos.add(studentDto);
		}

		response.setColumn(column);
		response.setData(studentDtos);

		return response;
	}

	@RequestMapping(value = "/find-by-kelas", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody DataTablesResponse getSiswaByKelas(@RequestBody(required = false) DataTablesRequest req) {
		DataTablesResponse response = new DataTablesResponse();
		List<String> column = new ArrayList<>();
		column.add("NIS");
		column.add("NISN");
		column.add("Nama");
		column.add("Jenis Kelamin");
		column.add("Tempat Lahir");
		column.add("Tanggal Lahir");
		column.add("Agama");
		column.add("Alamat");
		column.add("Kelas");
		column.add("Asal Sekolah");
		column.add("Status");

		List<com.structure.data.entity.Tmsiswa> studentDtos = new ArrayList<>();

		List<Tmsiswa> tmsiswas = tmsiswaDao.findByKelas(req.getSearch().get("kelas").toString());

		for (Tmsiswa tmsiswa : tmsiswas) {
			com.structure.data.entity.Tmsiswa studentDto = new com.structure.data.entity.Tmsiswa();
			studentDto.setNis(tmsiswa.getId().getNis());
			studentDto.setNisn(tmsiswa.getId().getNisn());
			studentDto.setNama(tmsiswa.getNama());
			studentDto.setJenisKelamin(tmsiswa.getJenisKelamin());
			studentDto.setTempatLahir(tmsiswa.getTempatLahir());
			studentDto.setTglLahir(tmsiswa.getTglLahir());
			studentDto.setAgama(tmsiswa.getAgama());
			studentDto.setAlamat(tmsiswa.getAlamat());
			studentDto.setKelas(tmsiswa.getKelas());
			studentDto.setAsalSekolah(tmsiswa.getAsalSekolah());
			studentDto.setStatus(tmsiswa.getStatus());

			studentDtos.add(studentDto);
		}

		response.setColumn(column);
		response.setData(studentDtos);

		return response;
	}

	@RequestMapping(value = "/insert-or-update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String insertSiswa(@RequestBody com.structure.data.entity.Tmsiswa data) {

		TmsiswaId id = new TmsiswaId();
		id.setNis(data.getNis());
		id.setNisn(data.getNisn());

		Tmsiswa tmsiswa = tmsiswaDao.findOne(id);
		if (tmsiswa == null) {
			tmsiswa = new Tmsiswa();
			tmsiswa.setId(id);
			tmsiswa.setNama(data.getNama());
			tmsiswa.setJenisKelamin(data.getJenisKelamin());
			tmsiswa.setTempatLahir(data.getTempatLahir());
			tmsiswa.setTglLahir(data.getTglLahir());
			tmsiswa.setAgama(data.getAgama());
			tmsiswa.setAlamat(data.getAlamat());
			tmsiswa.setKelas(data.getKelas());
			tmsiswa.setCreatedBy("Admin");
			tmsiswa.setCreatedDt(new Date());
			tmsiswa.setAsalSekolah(data.getAsalSekolah());
			tmsiswa.setStatus(data.getStatus());

		} else {
			tmsiswa.setNama(data.getNama());
			tmsiswa.setJenisKelamin(data.getJenisKelamin());
			tmsiswa.setTempatLahir(data.getTempatLahir());
			tmsiswa.setTglLahir(data.getTglLahir());
			tmsiswa.setAgama(data.getAgama());
			tmsiswa.setAlamat(data.getAlamat());
			tmsiswa.setKelas(data.getKelas());
			tmsiswa.setModifiedBy("Admin");
			tmsiswa.setModifiedDt(new Date());
			tmsiswa.setAsalSekolah(data.getAsalSekolah());
			tmsiswa.setStatus(data.getStatus());
		}

		tmsiswaDao.save(tmsiswa);

		return "1";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String deleteSiswa(@RequestBody com.structure.data.entity.Tmsiswa data) {

		TmsiswaId id = new TmsiswaId();
		id.setNis(data.getNis());
		id.setNisn(data.getNisn());

		Tmsiswa tmsiswa = tmsiswaDao.findOne(id);

		if (tmsiswa != null) {
			tmsiswaDao.delete(tmsiswa);
		}

		return "1";
	}

}
