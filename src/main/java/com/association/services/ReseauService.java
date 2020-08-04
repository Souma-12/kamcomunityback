package com.association.services;

import java.util.List;

import com.association.entity.Reseau;

public interface ReseauService {

	List<Reseau> getAll();

	Reseau getOne(Long id);

	Reseau save(Reseau reseau);

	boolean delete(Long id);

}
