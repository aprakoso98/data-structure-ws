package com.structure.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.structure.data.model.Tmsiswa;
import com.structure.data.model.TmsiswaId;

public interface TmsiswaDao extends CrudRepository<Tmsiswa, TmsiswaId> {

	public List<Tmsiswa> findByKelas(String kelas);

//	@Query("SELECT a.*. SUM(b.kelas) FROM Tmkelas a LEFT JOIN ")
//	public Long countSiswaByKelas(String kelas);
	
	@Query("SELECT a FROM Tmsiswa a WHERE a.status <> 'naik kelas'")
	public List<Tmsiswa> findByStatusMutasi();

	public List<Tmsiswa> findByStatus(String status);

	@Query("SELECT a FROM Tmsiswa a WHERE a.id.nis = ?1")
	public Tmsiswa findById(String nis);

}