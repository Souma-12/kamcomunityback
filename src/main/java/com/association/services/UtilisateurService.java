package com.association.services;

import java.util.List;

import com.association.entity.Utilisateur;

public interface UtilisateurService {

	List<Utilisateur> getAll();

	Utilisateur getOne(Long id);

	Utilisateur save(Utilisateur utilisateur);

	boolean delete(Long id);

	boolean findOneByEmail(String email);

	Utilisateur findUtilisateurByEmail(String email);

	Utilisateur findByUsername(String username);

	List<Utilisateur> findAllAdmin();

	List<Utilisateur> findAllAdherent();


}
