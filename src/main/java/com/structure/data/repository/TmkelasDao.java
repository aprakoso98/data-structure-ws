package com.structure.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.structure.data.model.Tmkelas;

public interface TmkelasDao extends CrudRepository<Tmkelas, String> {
	
//	@Query("SELECT a.idKelas, a.idWalikelas, a.jumlahKursi, a.jumlahMeja, COUNT(b.tmkelas) from Tmkelas "
//			+ "a LEFT JOIN a.tmsiswas b WHERE a.idKelas = b.tmkelas GROUP BY a.idKelas, a.idWalikelas, a.jumlahKursi, a.jumlahMeja")
//	public List<Tmkelas> countKelasPersiswa();

}
