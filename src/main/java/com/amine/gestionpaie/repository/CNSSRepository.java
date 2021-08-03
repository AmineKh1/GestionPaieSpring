package com.amine.gestionpaie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.model.anneeConfig.*;

public interface CNSSRepository extends JpaRepository< CNSS, Long>{

	Optional<CNSS> findCnssByAnnees(int annee);

}
