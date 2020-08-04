package com.association.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.association.entity.Reseau;
import com.association.repository.ReseauRepository;
import com.association.services.ReseauService;

@Service
public class ReseauServiceImpl implements ReseauService {

	@Autowired
	ReseauRepository reseauRepository;

	@Override
	public List<Reseau> getAll() {
		return reseauRepository.findAll();

	}

	@Override
	public Reseau getOne(Long id) {
		if (id != null)
			return reseauRepository.getOne(id);
		return new Reseau();
	}

	@Override
	public Reseau save(Reseau reseau) {
		if (reseau != null)
			return reseauRepository.save(reseau);
		return null;
	}

	@Override
	public boolean delete(Long id) {
		if (id != null) {
			reseauRepository.deleteById(id);

		}
		if (reseauRepository.getOne(id) == null) {
			return false;
		}
		return true;
	}

}
