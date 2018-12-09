package com.structure.data.rest.walisiswa;

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

import com.structure.data.model.Tmwalisiswa;
import com.structure.data.repository.TmwalisiswaDao;
import com.structure.data.util.DataTablesResponse;

@Controller
@RequestMapping("/rest/wali-siswa")
public class WaliSiswaRest {

	@Autowired
	private TmwalisiswaDao tmwalisiswaDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody DataTablesResponse getAllWaliSiswa() {
		DataTablesResponse response = new DataTablesResponse();
		List<String> column = new ArrayList<>();
		column.add("NIS");
		column.add("Nama Ayah");
		column.add("Tahun Lahir Ayah");
		column.add("Pendidikan Ayah");
		column.add("Pekerjaan Ayah");
		column.add("Penghasilan Min Ayah");
		column.add("Penghasilan Max Ayah");
		column.add("Nama Ibu");
		column.add("Tahun Lahir Ibu");
		column.add("Pendidikan Ibu");
		column.add("Pekerjaan Ibu");
		column.add("Penghasilan Min Ibu");
		column.add("Penghasilan Max Ibu");
		
		List<com.structure.data.entity.Tmwalisiswa> walisiswaDtos = new ArrayList<>();

		List<Tmwalisiswa> tmwalisiswas = (List<Tmwalisiswa>) tmwalisiswaDao.findAll();

		for (Tmwalisiswa tmwalisiswa : tmwalisiswas) {
			com.structure.data.entity.Tmwalisiswa walisiswaDto = new com.structure.data.entity.Tmwalisiswa();
			walisiswaDto.setNis(tmwalisiswa.getNis());
			walisiswaDto.setNamaAyah(tmwalisiswa.getNamaAyah());
			walisiswaDto.setTahunLahirAyah(tmwalisiswa.getTahunLahirAyah());
			walisiswaDto.setPendidikanAyah(tmwalisiswa.getPendidikanAyah());
			walisiswaDto.setPekerjaanAyah(tmwalisiswa.getPekerjaanAyah());
			walisiswaDto.setPenghasilanMinAyah(tmwalisiswa.getPenghasilanMinAyah());
			walisiswaDto.setPenghasilanMaxAyah(tmwalisiswa.getPenghasilanMaxAyah());
			walisiswaDto.setNamaIbu(tmwalisiswa.getNamaIbu());
			walisiswaDto.setTahunLahitIbu(tmwalisiswa.getTahunLahitIbu());
			walisiswaDto.setPendidikanIbu(tmwalisiswa.getPendidikanIbu());
			walisiswaDto.setPekerjaanIbu(tmwalisiswa.getPekerjaanIbu());
			walisiswaDto.setPenghasilanMinIbu(tmwalisiswa.getPenghasilanMinIbu());
			walisiswaDto.setPenghasilanMaxIbu(tmwalisiswa.getPenghasilanMaxIbu());

			walisiswaDtos.add(walisiswaDto);
		}
		
		response.setColumn(column);
		response.setData(walisiswaDtos);

		return response;
	}

	@RequestMapping(value = "/insert-or-update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String insertWalisiswa(@RequestBody com.structure.data.entity.Tmwalisiswa data) {

		Tmwalisiswa tmwalisiswa = tmwalisiswaDao.findOne(data.getNis());
		if (tmwalisiswa == null) {
			tmwalisiswa = new Tmwalisiswa();
			tmwalisiswa.setNis(data.getNis());
			tmwalisiswa.setNamaAyah(data.getNamaAyah());
			tmwalisiswa.setTahunLahirAyah(data.getTahunLahirAyah());
			tmwalisiswa.setPendidikanAyah(data.getPendidikanAyah());
			tmwalisiswa.setPekerjaanAyah(data.getPekerjaanAyah());
			tmwalisiswa.setPenghasilanMinAyah(data.getPenghasilanMinAyah());
			tmwalisiswa.setPenghasilanMaxAyah(data.getPenghasilanMaxAyah());
			tmwalisiswa.setNamaIbu(data.getNamaIbu());
			tmwalisiswa.setTahunLahitIbu(data.getTahunLahitIbu());
			tmwalisiswa.setPendidikanIbu(data.getPendidikanIbu());
			tmwalisiswa.setPekerjaanIbu(data.getPekerjaanIbu());
			tmwalisiswa.setPenghasilanMinIbu(data.getPenghasilanMinIbu());
			tmwalisiswa.setPenghasilanMaxIbu(data.getPenghasilanMaxIbu());
			tmwalisiswa.setCreatedBy("Admin");
			tmwalisiswa.setCreatedDt(new Date());

		} else {
			tmwalisiswa.setNamaAyah(data.getNamaAyah());
			tmwalisiswa.setTahunLahirAyah(data.getTahunLahirAyah());
			tmwalisiswa.setPendidikanAyah(data.getPendidikanAyah());
			tmwalisiswa.setPekerjaanAyah(data.getPekerjaanAyah());
			tmwalisiswa.setPenghasilanMinAyah(data.getPenghasilanMinAyah());
			tmwalisiswa.setPenghasilanMaxAyah(data.getPenghasilanMaxAyah());
			tmwalisiswa.setNamaIbu(data.getNamaIbu());
			tmwalisiswa.setTahunLahitIbu(data.getTahunLahitIbu());
			tmwalisiswa.setPendidikanIbu(data.getPendidikanIbu());
			tmwalisiswa.setPekerjaanIbu(data.getPekerjaanIbu());
			tmwalisiswa.setPenghasilanMinIbu(data.getPenghasilanMinIbu());
			tmwalisiswa.setPenghasilanMaxIbu(data.getPenghasilanMaxIbu());
			tmwalisiswa.setModifiedBy("Admin");
			tmwalisiswa.setModifiedDt(new Date());

		}

		tmwalisiswaDao.save(tmwalisiswa);

		return "1";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String deleteSiswa(@RequestBody com.structure.data.entity.Tmwalisiswa data) {

		Tmwalisiswa tmwalisiswa = tmwalisiswaDao.findOne(data.getNis());

		if (tmwalisiswa != null) {
			tmwalisiswaDao.delete(tmwalisiswa);
		}

		return "1";
	}

}
