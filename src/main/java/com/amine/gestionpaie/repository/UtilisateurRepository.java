package com.amine.gestionpaie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.amine.gestionpaie.model.Societe;
import com.amine.gestionpaie.model.utilisateurs.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

	@Query(value = "select u from Utilisateur u where u.email = :email")
	  Optional<Utilisateur> findUtilisateurByEmail(@Param("email") String email);



}
