package com.amine.gestionpaie.services;

import java.util.List;

import com.amine.gestionpaie.dto.*;
import com.amine.gestionpaie.model.Employe;

public interface EmployeServices {
	EmployeDto save(EmployeDto dto);
	EmployeDto findById(Long id);
	EmployeDto findBycin(String cin);
	List<EmployeDto> findAll();
	void delete(Long id);
	List<EmployeDto> findAllByIdSociete(Long idSociete);
	List<EmployeDto> findAllByIdBanque(Long idBanque);
	List<EmployeDto> findAllByIdDepartement(Long idDepartement);


}
