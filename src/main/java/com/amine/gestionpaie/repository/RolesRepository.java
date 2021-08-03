package com.amine.gestionpaie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.model.utilisateurs.Roles;

public interface RolesRepository extends JpaRepository<Roles,Long>{

}
