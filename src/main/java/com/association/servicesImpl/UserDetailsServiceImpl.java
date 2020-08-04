package com.association.servicesImpl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.association.entity.Utilisateur;
import com.association.repository.UtilisateurRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("zzzzzzzzz", username);

		Utilisateur utilisateur = utilisateurRepository.findByUsername(username);
		log.info("ssss", utilisateur);

		if (utilisateur == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(utilisateur.getUsername(),
				utilisateur.getPassword(), getAuthority());
	}

	
	
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}


}