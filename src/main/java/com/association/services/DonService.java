package com.association.services;

import java.util.List;

import com.association.entity.Don;


public interface DonService {

	List<Don> getAll();

	Don getOne(Long id);

	Don save(Don don);

	boolean delete(Long id);

	List<Don> getAllByUtilisateur(Long id);

	List<Don> getAllByAssociation(Long id);
}
