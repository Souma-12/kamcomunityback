package com.association.services;

import java.util.List;

import com.association.entity.Pays;

public interface PaysService {

	List<Pays> getAll();

	Pays getOne(Long id);

	Pays save(Pays pays);

	boolean delete(Long id);

}
