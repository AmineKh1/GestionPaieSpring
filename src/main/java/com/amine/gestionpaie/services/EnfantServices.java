package com.amine.gestionpaie.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.amine.gestionpaie.dto.*;

public interface EnfantServices {
	EnfantDto save(EnfantDto dto);
	EnfantDto findById(Long id);
	List<EnfantDto> findAll();
	void delete(Long id);
	Collection<EnfantDto> findAllByIdEmployeEnfant(Long idEmploye);
	int findMineur(Collection<EnfantDto> enfant,Date dateB);

}
