package com.amine.gestionpaie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.model.anneeConfig.FraisPro;

public interface FraisProRepository extends JpaRepository<FraisPro,Long>{

	Optional<FraisPro> findByAnnees(int annee);

}
