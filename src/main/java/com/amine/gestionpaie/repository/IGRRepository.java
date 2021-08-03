package com.amine.gestionpaie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.model.anneeConfig.*;

public interface IGRRepository extends JpaRepository< IGR, Long>{
	Optional<IGR> findIGRByAnnees(int annee);



}
