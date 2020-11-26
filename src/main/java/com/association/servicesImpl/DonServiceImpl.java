package com.association.servicesImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.association.entity.Don;
import com.association.repository.DonRepository;
import com.association.services.DonService;
import com.association.utils.SumResponseByAssociation;
import com.association.utils.SumResponseByUser;

@Service
public class DonServiceImpl implements DonService {

	private final Logger log = LoggerFactory.getLogger(DonServiceImpl.class);

	@Autowired
	DonRepository donRepository;

	@Override
	public List<Don> getAll() {
		return donRepository.findAll();

	}

	@Override
	public Don getOne(Long id) {
		if (id != null)
			return donRepository.getOne(id);
		return new Don();
	}

	@Override
	public Don save(Don don) {
		if (don != null)
			return donRepository.save(don);
		return null;
	}

	@Override
	public boolean delete(Long id) {
		if (id != null) {
			donRepository.deleteById(id);

		}
		if (donRepository.getOne(id) == null) {
			return false;
		}
		return true;
	}

	@Override
	public List<Don> getAllByUtilisateur(Long id) {
		List<Don> result = donRepository.findByUtilisateur(id);
		return result;
	}

	@Override
	public List<Don> getAllByAssociation(Long id) {
		List<Don> result = donRepository.findByAssociation(id);
		return result;
	}

	@Override
	public SumResponseByUser SommeByUtilisateur(Long id) {
		SumResponseByUser SumResponseByUser = donRepository.SumByUtilisateur(id);

		return SumResponseByUser;

	}

	@Override
	public SumResponseByAssociation SommeByAssociation(Long id) {
		SumResponseByAssociation result = donRepository.SumByAssociation(id);
		log.info("---- result : {}", result);

		return result;

	}
}
