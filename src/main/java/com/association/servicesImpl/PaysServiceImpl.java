package com.association.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.association.entity.Pays;
import com.association.repository.PaysRepository;
import com.association.services.PaysService;

@Service
public class PaysServiceImpl implements PaysService{

	@Autowired
	PaysRepository paysRepository;

	@Override
	public List<Pays> getAll() {
		return paysRepository.findAll();

	}

	@Override
	public Pays getOne(Long id) {
		if (id != null)
			return paysRepository.getOne(id);
		return new Pays();
	}

	@Override
	public Pays save(Pays pays) {
		if (pays != null)
			return paysRepository.save(pays);
		return null;
	}

	@Override
	public boolean delete(Long id) {
		if (id != null) {
			paysRepository.deleteById(id);

		}
		if (paysRepository.getOne(id) == null) {
			return false;
		}
		return true;
	}

}
