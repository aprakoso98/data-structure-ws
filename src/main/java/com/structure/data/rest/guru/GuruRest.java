package com.structure.data.rest.guru;

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

import com.structure.data.model.Tmguru;
import com.structure.data.model.TmguruId;
import com.structure.data.repository.TmguruDao;

@Controller
@RequestMapping("/rest/guru")
public class GuruRest {

	@Autowired
	private TmguruDao tmguruDao;

	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public @ResponseBody List<com.structure.data.entity.Tmguru> getAllGuru() {
		List<com.structure.data.entity.Tmguru> guruDtos = new ArrayList<>();

		List<Tmguru> tmgurus = (List<Tmguru>) tmguruDao.findAll();

		for (Tmguru tmguru : tmgurus) {
			com.structure.data.entity.Tmguru guruDto = new com.structure.data.entity.Tmguru();
			guruDto.setIdGuru(tmguru.getId().getIdGuru());
			guruDto.setNip(tmguru.getId().getNip());
			guruDto.setNamaGuru(tmguru.getNamaGuru());
			guruDto.setAlamat(tmguru.getAlamat());

			guruDtos.add(guruDto);
		}

		return guruDtos;
	}

	@RequestMapping(value = "/insert-or-update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String insertGuru(@RequestBody com.structure.data.entity.Tmguru data) {

		TmguruId id = new TmguruId();
		id.setIdGuru(data.getIdGuru());
		id.setNip(data.getNip());

		Tmguru tmguru = tmguruDao.findOne(id);
		if (tmguru == null) {
			tmguru = new Tmguru();
			tmguru.setId(id);
			tmguru.setNamaGuru(data.getNamaGuru());
			tmguru.setAlamat(data.getAlamat());
			tmguru.setCreatedBy("Admin");
			tmguru.setCreatedDt(new Date());

		} else {
			tmguru.setNamaGuru(data.getNamaGuru());
			tmguru.setAlamat(data.getAlamat());
			tmguru.setModifiedBy("Admin");
			tmguru.setModifiedDt(new Date());
		}

		tmguruDao.save(tmguru);

		return "1";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String deleteGuru(@RequestBody com.structure.data.entity.Tmguru data) {

		TmguruId id = new TmguruId();
		id.setIdGuru(data.getIdGuru());
		id.setNip(data.getNip());

		Tmguru tmguru = tmguruDao.findOne(id);

		if (tmguru != null) {
			tmguruDao.delete(tmguru);
		}

		return "1";
	}

}
