package com.structure.data.kelas.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<com.structure.data.entity.Tmkelas> getAllKelas() {
		List<com.structure.data.entity.Tmkelas> kelasDtos = new ArrayList<>();

		List<Tmkelas> tmkelases = (List<Tmkelas>) tmkelasDao.findAll();

		for (Tmkelas tmkelas : tmkelases) {
			com.structure.data.entity.Tmkelas kelasDto = new com.structure.data.entity.Tmkelas();
			kelasDto.setKelas(tmkelas.getIdKelas());

			kelasDtos.add(kelasDto);
		}

		return kelasDtos;
	}

}
