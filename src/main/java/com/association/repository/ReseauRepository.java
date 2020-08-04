package com.association.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.association.entity.Reseau;

@Repository
public interface ReseauRepository extends JpaRepository<Reseau, Long> {

}
