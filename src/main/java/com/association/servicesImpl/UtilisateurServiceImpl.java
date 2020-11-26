package com.association.servicesImpl;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.association.entity.Role;
import com.association.entity.Utilisateur;
import com.association.repository.RoleRepository;
import com.association.repository.UtilisateurRepository;
import com.association.services.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	Logger log = LoggerFactory.getLogger(UtilisateurServiceImpl.class);

	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Autowired
	RoleRepository roleRepository;

	public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepositroy, HttpServletRequest request) {
		super();
		this.utilisateurRepository = utilisateurRepositroy;
	}

	@Override
	public List<Utilisateur> getAll() {
		return utilisateurRepository.findAll();

	}

	@Override
	public Utilisateur getOne(Long id) {
		if (id != null)
			return utilisateurRepository.findById(id).orElse(null);
		return null;
	}

	@Override
	@Transactional
	public Utilisateur save(Utilisateur utilisateur) {
		log.info("sdvsd :{}", roleRepository.findById(utilisateur.getRole().getId()).get());
		utilisateur.setRole(roleRepository.findById(utilisateur.getRole().getId()).get());
		if (utilisateur != null)
			return utilisateurRepository.save(utilisateur);
		return utilisateur;
	}

	@Override
	public boolean delete(Long id) {
		if (id != null) {
			utilisateurRepository.deleteById(id);

		}
		if (utilisateurRepository.getOne(id) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean findOneByEmail(String email) {
		if (email != null)
			if (utilisateurRepository.findByEmail(email) == null)
				return false;
		return true;

	}

	@Override
	public Utilisateur findUtilisateurByEmail(String email) {
		Utilisateur utilisateur = null;
		if (email != null) {
			utilisateur = utilisateurRepository.findByEmail(email);
		}
		if (utilisateur != null) {
			return utilisateur;
		} else {
			return null;
		}

	}

	@Override
	public Utilisateur findByUsername(String username) {
		Optional<Utilisateur> result = Optional.ofNullable(utilisateurRepository.findByUsername(username));
		if (result.isPresent())
			return result.get();
		log.info("zzzzzzzzz", username);

		return null;

	}

	@Override
	public List<Utilisateur> findAllAdmin() {
		Role role = roleRepository.getOne((long) 1);
		List<Utilisateur> users = utilisateurRepository.findAllByRole(role);
		return users;
	}

	@Override
	public List<Utilisateur> findAllAdherent() {
		Role role = roleRepository.getOne((long) 3);
		List<Utilisateur> users = utilisateurRepository.findAllByRole(role);
		return users;
	}

}
