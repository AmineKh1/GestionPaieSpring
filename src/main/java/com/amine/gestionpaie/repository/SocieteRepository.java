package com.amine.gestionpaie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.model.Departement;
import com.amine.gestionpaie.model.Societe;

public interface SocieteRepository extends JpaRepository< Societe, Long>{

	Optional<Societe> findSocieteByNomSociete(String nomSociete);

}
