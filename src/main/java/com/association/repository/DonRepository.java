package com.association.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.association.entity.Don;

@Repository
public interface DonRepository extends JpaRepository<Don, Long> {
	
	
	//@Query(value = "SELECT *  FROM Don u WHERE u.id_association = :id_association and u.id=:id",  nativeQuery = true)
	List <Don> findByAssociation(Long id);

	//@Query(value = "SELECT * FROM Don,Utilisateur u WHERE u.id_utilisateur = :id_utilisateur and u.id=:id",  nativeQuery = true)
	List <Don> findByUtilisateur(Long id);
	
	

}

