package com.amine.gestionpaie.services.impl;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.PrimeCourantDto;
import com.amine.gestionpaie.dto.PrimeNoExoDto;
import com.amine.gestionpaie.dto.PrimeNormalDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.model.PrimeNoExo;
import com.amine.gestionpaie.model.PrimeNormal;
import com.amine.gestionpaie.repository.EmployeRepository;
import com.amine.gestionpaie.repository.PrimeNoExoRepository;
import com.amine.gestionpaie.services.PrimeNoExoServices;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class PrimeNoExoServiceImpl implements PrimeNoExoServices{
	private PrimeNoExoRepository primeNoExoRepository;
	private EmployeRepository employeRepository;
	@Override
	public Double calculSolePrime(Collection<PrimeNoExoDto> prime) {
		Double some=null;
		for (PrimeNoExoDto  prim : prime) {
			some=some+prim.getValeurPrime();
		}
		return some;
	}
	

	@Override
	public PrimeNoExoDto findByNom(String nom) {
		// TODO Auto-generated method stub
		if(!StringUtils.hasLength(nom)) {
			log.error("Prime Nom is null");
			return null;
		}
		Optional<PrimeNoExo> prime= primeNoExoRepository.findPrimeByNomPrime(nom);
		PrimeNoExoDto dto= PrimeNoExoDto.fromEntity(prime.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucn prime avec le nom ="+nom+"n'a ete trouve dans la base de données",ErrorCodes.PRIME_NOT_FOUND));
	}
	@Override
	
	public Collection<PrimeNoExoDto> findByPrimeEmployeAndDate(Long idEmploye, Date date) {
		if(idEmploye==null) {
			log.error("prime id employe is null");
			return null;
		}
		if(date==null) {
			log.error("prime id employe is null");
			return null;
		}
		Collection<PrimeNoExoDto> prime= primeNoExoRepository.findPrimeByDateAndIdForBulletinPaie(idEmploye, date).stream().map(PrimeNoExoDto::fromEntity).collect(Collectors.toList());
		
		return  prime;

	}

}
