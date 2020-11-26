package com.association.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.association.entity.Don;
import com.association.utils.SumResponseByAssociation;
import com.association.utils.SumResponseByUser;

@Repository
public interface DonRepository extends JpaRepository<Don, Long> {

	List<Don> findByAssociation(Long id);

	List<Don> findByUtilisateur(Long id);

	@Query(value = "select new com.association.utils.SumResponseByUser( d.utilisateur.prenom, SUM(d.montant))from Don d  where d.utilisateur.id_utilisateur =:id GROUP BY d.utilisateur.id_utilisateur")
	SumResponseByUser SumByUtilisateur(@Param("id") Long id);

	@Query(value = "select new com.association.utils.SumResponseByAssociation (d.association.id_association, SUM(d.montant)) from Don d  where d.association.id_association =:id GROUP BY d.association.id_association")
	SumResponseByAssociation SumByAssociation(Long id);

}
