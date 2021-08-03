package com.amine.gestionpaie.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.amine.gestionpaie.dto.*;

public interface PrimeNormalServices {
	PrimeNormalDto save(PrimeNormalDto dto);
	PrimeNormalDto findById(Long id);
	PrimeNormalDto findByNom(String nom);
	void delete(Long id);
	Collection<PrimeNormalDto> findByPrimeEmployeAndDate(Long idEmploye,Date date);
	Double calculSolePrime(Collection<PrimeNormalDto> prime);


	
}
