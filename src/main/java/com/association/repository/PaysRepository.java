package com.association.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.association.entity.Pays;

@Repository
public interface PaysRepository extends JpaRepository<Pays, Long> {

}
