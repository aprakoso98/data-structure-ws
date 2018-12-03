package com.structure.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.structure.data.model.Tmsiswa;
import com.structure.data.model.TmsiswaId;

public interface TmsiswaDao extends CrudRepository<Tmsiswa, TmsiswaId> {
	
	public List<Tmsiswa> findByKelas(String kelas);

}