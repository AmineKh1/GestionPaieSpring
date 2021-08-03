package com.amine.gestionpaie.controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.PrimeApi;
import com.amine.gestionpaie.dto.PrimeNormalDto;
import com.amine.gestionpaie.services.PrimeNormalServices;

@RestController

public class PrimeController implements PrimeApi{
	private PrimeNormalServices primeService;
	@Autowired
	public PrimeController(PrimeNormalServices primeService) {
		this.primeService = primeService;
	}

	@Override
	public PrimeNormalDto save(PrimeNormalDto dto) {
		return primeService.save(dto);
	}

	@Override
	public PrimeNormalDto findById(Long id) {
		return primeService.findById(id);
	}

	@Override
	public PrimeNormalDto findByNom(String nom) {
		return primeService.findByNom(nom);
	}

	@Override
	public void delete(Long id) {
		primeService.delete(id);		
	}

	@Override
	public Collection<PrimeNormalDto> findByPrimeEmployeAndDate(Long idEmploye, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calculSolePrime(Collection<PrimeNormalDto> prime) {
		// TODO Auto-generated method stub
		return null;
	}

}
