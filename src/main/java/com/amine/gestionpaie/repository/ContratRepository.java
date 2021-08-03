package com.amine.gestionpaie.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.amine.gestionpaie.model.*;

public interface ContratRepository extends JpaRepository< Contrat, Long>{

	Optional<Contrat> findContratByTypeContrat(String type);

	Optional<Contrat> findContratByProfession(String profession);

	Optional<Contrat> findContratByEmployeContrat(Long idEmploye);
	@Query(value="SELECT MAX(d) FROM contrat WHERE d.date_embauche<(DATE(:date)) and d.employe_contrat=:id")
	Optional<Contrat> findContratByDateAndIdForBulletinPaie(Long id,Date date);



}
