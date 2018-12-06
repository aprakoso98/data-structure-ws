package com.structure.data.rest.sekolah;

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

import com.structure.data.model.Tmsekolah;
import com.structure.data.repository.TmsekolahDao;

@Controller
@RequestMapping("/rest/sekolah")
public class SekolahRest {

	@Autowired
	private TmsekolahDao tmsekolahDao;

	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public @ResponseBody List<com.structure.data.entity.Tmsekolah> getAllSekolah() {
		List<com.structure.data.entity.Tmsekolah> sekolahDtos = new ArrayList<>();

		List<Tmsekolah> tmsekolahs = (List<Tmsekolah>) tmsekolahDao.findAll();

		for (Tmsekolah tmsekolah : tmsekolahs) {
			com.structure.data.entity.Tmsekolah sekolahDto = new com.structure.data.entity.Tmsekolah();
			sekolahDto.setIdSekolah(tmsekolah.getIdSekolah());
			sekolahDto.setNamaSekolah(tmsekolah.getNamaSekolah());
			sekolahDto.setAlamat(tmsekolah.getAlamat());
			sekolahDto.setTglBerdiri(tmsekolah.getTglBerdiri());

			sekolahDtos.add(sekolahDto);
		}

		return sekolahDtos;
	}

	@RequestMapping(value = "/insert-or-update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String insertSekolah(@RequestBody com.structure.data.entity.Tmsekolah data) {

		Tmsekolah tmsekolah = tmsekolahDao.findOne(data.getIdSekolah());
		if (tmsekolah == null) {
			tmsekolah = new Tmsekolah();
			tmsekolah.setIdSekolah(data.getIdSekolah());
			tmsekolah.setNamaSekolah(data.getNamaSekolah());
			tmsekolah.setAlamat(data.getAlamat());
			tmsekolah.setTglBerdiri(data.getTglBerdiri());
			tmsekolah.setCreatedBy("Admin");
			tmsekolah.setCreatedDt(new Date());

		} else {
			tmsekolah.setNamaSekolah(data.getNamaSekolah());
			tmsekolah.setAlamat(data.getAlamat());
			tmsekolah.setTglBerdiri(data.getTglBerdiri());
			tmsekolah.setModifiedBy("Admin");
			tmsekolah.setModifiedDt(new Date());
		}

		tmsekolahDao.save(tmsekolah);

		return "1";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String deleteSekolah(@RequestBody com.structure.data.entity.Tmsekolah data) {

		Tmsekolah tmsekolah = tmsekolahDao.findOne(data.getIdSekolah());

		if (tmsekolah != null) {
			tmsekolahDao.delete(tmsekolah);
		}

		return "1";
	}

}
