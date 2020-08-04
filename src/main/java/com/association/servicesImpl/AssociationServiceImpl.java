package com.association.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.association.entity.Association;
import com.association.repository.AssociationRepository;
import com.association.services.AssociationService;

@Service
public class AssociationServiceImpl implements AssociationService {

	@Autowired
	AssociationRepository associationRepository;

	@Override
	public List<Association> getAll() {
		return associationRepository.findAll();
		
	}

	@Override
	public Association getOne(Long id) {
		if (id != null)
		return associationRepository.getOne(id);
		return new Association();
	}

	@Override
	public Association save(Association association) {
		if (association != null)
			return associationRepository.save(association);
		return null;
	}

	@Override
	public boolean delete(Long id) {
		if (id != null) {
			associationRepository.deleteById(id);

		}
		if (associationRepository.getOne(id) == null) {
			return false;
		}
		return true;
	}

}
