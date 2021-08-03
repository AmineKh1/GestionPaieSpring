package com.amine.gestionpaie.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.model.PrimeCourant;

public interface PrimeCourantRepository extends JpaRepository<PrimeCourant, Long>{
	


	Collection<PrimeCourant> findAllByEmployePrime(Long idEmploye);

	

}
