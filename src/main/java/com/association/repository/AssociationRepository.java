package com.association.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.association.entity.Association;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {

}
