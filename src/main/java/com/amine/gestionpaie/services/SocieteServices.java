package com.amine.gestionpaie.services;

import java.util.List;

import com.amine.gestionpaie.dto.DepartementDto;
import com.amine.gestionpaie.dto.SocieteDto;
import com.amine.gestionpaie.model.Departement;

public interface SocieteServices {
	SocieteDto save(SocieteDto dto);
	SocieteDto findById(Long id);
	SocieteDto findByNomSociete(String nomSociete);
	List<SocieteDto> findAll();
	void delete(Long id);
	
}
