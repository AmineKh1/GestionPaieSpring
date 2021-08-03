package com.amine.gestionpaie.repository;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.amine.gestionpaie.model.*;

public interface PrimeNormalRepository extends JpaRepository< PrimeNormal, Long>{
	Optional<PrimeNormal> findPrimeByNomPrime(String nomPrime);
	@Query(value="SELECT * FROM primenormal WHERE d.date_dateaffectationp<(DATE(:date)) and d.employeprime=:idEmploye")
	Collection<PrimeNormal> findPrimeByDateAndIdForBulletinPaie(Long idEmploye, Date date);
}
