package com.amine.gestionpaie.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.amine.gestionpaie.dto.*;

public interface CreditServices {
	
	CreditDto save(CreditDto dto);
	CreditDto findById(Long id);
	List<CreditDto> findAll();
	void delete(Long id);
	Collection<CreditDto> findAllByIdEmployeAndDate(Long idEmploye,Date date);

}
