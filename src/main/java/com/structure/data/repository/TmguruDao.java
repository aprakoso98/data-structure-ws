package com.structure.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.structure.data.model.Tmguru;
import com.structure.data.model.TmguruId;

public interface TmguruDao extends CrudRepository<Tmguru, TmguruId> {

}
