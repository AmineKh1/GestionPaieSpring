package com.amine.gestionpaie.services;

import java.util.Collection;
import java.util.Date;

import com.amine.gestionpaie.dto.PrimeCourantDto;
import com.amine.gestionpaie.dto.PrimeNoExoDto;
import com.amine.gestionpaie.dto.PrimeNormalDto;

public interface PrimeNoExoServices {
	Double calculSolePrime(Collection<PrimeNoExoDto> prime);
	PrimeNoExoDto findByNom(String nom);
	Collection<PrimeNoExoDto> findByPrimeEmployeAndDate(Long idEmploye, Date date);
}
