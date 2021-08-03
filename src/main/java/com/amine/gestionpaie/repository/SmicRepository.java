package com.amine.gestionpaie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.amine.gestionpaie.model.anneeConfig.Smic;


public interface SmicRepository extends JpaRepository< Smic, Long>{
	Optional<Smic> findSmicByAnnees(int annees);

}
