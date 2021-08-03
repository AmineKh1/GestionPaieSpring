package com.amine.gestionpaie.services;

import java.util.Collection;
import java.util.Date;

import com.amine.gestionpaie.dto.PrimeCourantDto;
import com.amine.gestionpaie.dto.PrimeNormalDto;

public interface PrimeCourantServices {
	PrimeCourantDto save(PrimeCourantDto dto);
	PrimeCourantDto findById(Long id);
	PrimeCourantDto findByType(String type);
	void delete(Long id);
	Collection<PrimeCourantDto> findByPrimeEmployeAndDate(Long idEmploye, Date date);
	Double calculSolePrime(Collection<PrimeCourantDto> prime);


}
