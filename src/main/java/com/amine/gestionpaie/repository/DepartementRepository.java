package com.amine.gestionpaie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.dto.DepartementDto;
import com.amine.gestionpaie.model.*;

public interface DepartementRepository extends JpaRepository< Departement, Long>{

	Optional<Departement> findBySocieteIdSociete(Long idSociete);

	List<Departement> findAllBySociete(Long idSociete);

	List<Departement> findAllBySocieteIdSociete(Long idSociete);

}
