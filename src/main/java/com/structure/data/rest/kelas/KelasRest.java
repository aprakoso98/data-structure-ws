package com.structure.data.rest.kelas;

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

import com.structure.data.model.Tmkelas;
import com.structure.data.repository.TmkelasDao;

@Controller
@RequestMapping("/rest/kelas")
public class KelasRest {

	@Autowired
	private TmkelasDao tmkelasDao;

	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public @ResponseBody List<com.structure.data.entity.Tmkelas> getAllKelas() {
		List<com.structure.data.entity.Tmkelas> kelasDtos = new ArrayList<>();

		List<Tmkelas> tmkelases = (List<Tmkelas>) tmkelasDao.findAll();

		for (Tmkelas tmkelas : tmkelases) {
			com.structure.data.entity.Tmkelas kelasDto = new com.structure.data.entity.Tmkelas();
			kelasDto.setIdKelas(tmkelas.getIdKelas());

			kelasDtos.add(kelasDto);
		}

		return kelasDtos;
	}

	@RequestMapping(value = "/insert-or-update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String insertKelas(@RequestBody com.structure.data.entity.Tmkelas data) {

		Tmkelas tmkelas = tmkelasDao.findOne(data.getIdKelas());
		if (tmkelas == null) {
			tmkelas = new Tmkelas();
			tmkelas.setIdKelas(data.getIdKelas());
			tmkelas.setIdWalikelas(data.getIdWalikelas());
			tmkelas.setJumlahKursi(data.getJumlahKursi());
			tmkelas.setJumlahMeja(data.getJumlahMeja());
			tmkelas.setCreatedBy("Admin");
			tmkelas.setCreatedDt(new Date());

		} else {
			tmkelas.setIdWalikelas(data.getIdWalikelas());
			tmkelas.setJumlahKursi(data.getJumlahKursi());
			tmkelas.setJumlahMeja(data.getJumlahMeja());
			tmkelas.setModifiedBy("Admin");
			tmkelas.setModifiedDt(new Date());
		}

		tmkelasDao.save(tmkelas);

		return "1";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String deleteKelas(@RequestBody com.structure.data.entity.Tmkelas data) {

		Tmkelas tmkelas = tmkelasDao.findOne(data.getIdKelas());

		if (tmkelas != null) {
			tmkelasDao.delete(tmkelas);
		}

		return "1";
	}

}
