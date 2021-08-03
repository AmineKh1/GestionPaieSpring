package com.amine.gestionpaie.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.dto.EmployeDto;
import com.amine.gestionpaie.model.*;

public interface EmployeRepository extends JpaRepository< Employe, Long>{
	Optional<Employe> findEmployeByCin(String cin);

	List<Employe> findAllBySociete(Long idSociete);

	Collection<Employe> findAllByBanque(Long idBanque);

	List<Employe> findAllByDepartement(Long idDepartement);

	Optional<Employe> findBySocieteIdSociete(Long idSociete);

	Optional<Employe> findByDepartementNumDep(Long idDepartement);

	Optional<Employe> findByBanqueIdBanque(Long idBanque);






}
