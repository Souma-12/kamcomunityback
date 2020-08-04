package com.association.servicesImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.association.entity.Utilisateur;
import com.association.repository.UtilisateurRepository;
import com.association.services.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	Logger log = LoggerFactory.getLogger(UtilisateurServiceImpl.class);

	@Autowired
	UtilisateurRepository utilisateurRepository;

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
	public Utilisateur save(Utilisateur utilisateur) {
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
	
	
}
