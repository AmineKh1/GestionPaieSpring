package com.amine.gestionpaie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.model.*;

public interface CongeRepository extends JpaRepository< Conge, Long>{

	Optional<Conge> findCongeByType(String type);

}
