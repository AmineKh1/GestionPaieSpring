package com.amine.gestionpaie.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.amine.gestionpaie.dto.*;

public interface AvanceServices {
	AvanceDto save(AvanceDto dto);
	AvanceDto findById(Long id);
	Collection<AvanceDto> findByEmployeAvanceAndDateMoisA(Long idEmploye,Date date);
	List<AvanceDto> findAll();
	void delete(Long id);

}
