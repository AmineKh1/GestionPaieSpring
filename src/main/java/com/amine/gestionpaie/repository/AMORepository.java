package com.amine.gestionpaie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.model.Contrat;
import com.amine.gestionpaie.model.anneeConfig.*;

public interface AMORepository extends JpaRepository<AMO, Long>{

	Optional<AMO> findContratByAnnees(int annee);

}
