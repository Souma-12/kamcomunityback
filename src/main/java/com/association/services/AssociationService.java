package com.association.services;

import java.util.List;

import com.association.entity.Association;



public interface AssociationService {
	
	List<Association> getAll();

	Association getOne(Long id);

	Association save(Association association);

	boolean delete(Long id);

}
