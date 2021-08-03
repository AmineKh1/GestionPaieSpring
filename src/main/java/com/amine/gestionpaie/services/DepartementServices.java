package com.amine.gestionpaie.services;

import java.util.List;

import com.amine.gestionpaie.dto.*;

public interface DepartementServices {
	DepartementDto save(DepartementDto dto);
	DepartementDto findById(Long id);
	List<DepartementDto> findAll();
	void delete(Long id);
	List<DepartementDto> findAllByIdSociete(Long idSociete);
	

}
