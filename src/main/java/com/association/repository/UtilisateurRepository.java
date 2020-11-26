package com.association.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.association.entity.Role;
import com.association.entity.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	public Utilisateur findByEmail(String email);

	Utilisateur findByUsername(String username);

	public List<Utilisateur> findAllByRole(Role role);

}
