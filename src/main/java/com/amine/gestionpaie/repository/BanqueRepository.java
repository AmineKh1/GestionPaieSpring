package com.amine.gestionpaie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.model.*;

public interface BanqueRepository extends JpaRepository<Banque,Long>{
	
	Optional<Banque> findByNomBanque(String nomBanque);
}
