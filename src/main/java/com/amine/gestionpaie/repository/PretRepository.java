package com.amine.gestionpaie.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.amine.gestionpaie.model.*;

public interface PretRepository extends JpaRepository<Pret, Long>{
	
	@Query(value="SELECT * FROM pret WHERE d.date_dateaffectationp<(DATE(:date)) and d.employepret=:idEmploye")
	Collection<Pret> findAllPretByDateAndIdForBulletinPaie(Long idEmploye, Date date);

}
