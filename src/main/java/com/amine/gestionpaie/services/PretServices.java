package com.amine.gestionpaie.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.amine.gestionpaie.dto.*;

public interface PretServices {
	PretDto save(PretDto dto);
	PretDto findById(Long id);
	List<PretDto> findAll();
	void delete(Long id);
	Collection<PretDto> findByPretEmployeAndDate(Long idEmploye,Date date);

}
