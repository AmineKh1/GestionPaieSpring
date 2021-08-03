package com.amine.gestionpaie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.model.anneeConfig.Anciennete;

public interface AncienneteRepository extends JpaRepository< Anciennete, Long>{

	Optional<Anciennete> findAncienneteByAnnees(int annee);

}
