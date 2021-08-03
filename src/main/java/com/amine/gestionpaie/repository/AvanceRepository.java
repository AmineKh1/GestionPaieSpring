package com.amine.gestionpaie.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.model.Avance;

public interface AvanceRepository extends JpaRepository<Avance, Long>{
	Collection<Avance> findAllByEmployeAvanceAndDateMoisA(Long idEmploye,Date date);

}
