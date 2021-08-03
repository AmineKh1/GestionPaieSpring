package com.amine.gestionpaie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.model.anneeConfig.Mutuelle;

public interface MutuelleRepository extends JpaRepository< Mutuelle, Long>{

	Optional<Mutuelle> findMutuelleByAnnees(int annee);

}
