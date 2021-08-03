package com.amine.gestionpaie.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.model.*;

public interface CreditRepository extends JpaRepository< Credit, Long>{

	Collection<Credit> findAllByEmployeCreditAndDateAffectation(Long idEmploye,Date date);

}
