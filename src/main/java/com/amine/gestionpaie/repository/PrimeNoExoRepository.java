package com.amine.gestionpaie.repository;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.amine.gestionpaie.dto.PrimeNoExoDto;
import com.amine.gestionpaie.model.PrimeNoExo;

public interface PrimeNoExoRepository extends JpaRepository<PrimeNoExo,Long>{

	Optional<PrimeNoExo> findPrimeByNomPrime(String nom);
	@Query(value="SELECT * FROM primenoexo WHERE d.date_dateaffectationp<(DATE(:date)) and d.employeprime=:idEmploye")
	Collection<PrimeNoExo> findPrimeByDateAndIdForBulletinPaie(Long idEmploye, Date date);

}
