package com.amine.gestionpaie.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.dto.EnfantDto;
import com.amine.gestionpaie.model.*;

public interface EnfantRepository extends JpaRepository< Enfant, Long>{
	Collection<Enfant> findAllByEmployeEnfant(Long idEmploye);
	

}
