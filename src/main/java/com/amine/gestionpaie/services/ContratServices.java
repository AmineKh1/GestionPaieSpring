package com.amine.gestionpaie.services;

import java.util.Date;
import java.util.List;

import com.amine.gestionpaie.dto.*;

public interface ContratServices {
	ContratDto save(ContratDto dto);
	ContratDto findById(Long id);
	ContratDto findByType(String type);
	ContratDto findByProfession(String Profession);
	List<ContratDto> findAll();
	void delete(Long id);

	ContratDto findByEmployeContratAndDate(Long idEmploye, Date date);
	Long CalculeAnciennete(Date date,Date dateBulletin);
	
}
