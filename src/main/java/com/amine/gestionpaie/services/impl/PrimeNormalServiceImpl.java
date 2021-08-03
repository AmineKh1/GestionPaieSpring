package com.amine.gestionpaie.services.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.AncienneteListDto;
import com.amine.gestionpaie.dto.EmployeDto;
import com.amine.gestionpaie.dto.PrimeNormalDto;
import com.amine.gestionpaie.dto.SocieteDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.Employe;
import com.amine.gestionpaie.model.Prime;
import com.amine.gestionpaie.model.PrimeNormal;
import com.amine.gestionpaie.model.Societe;
import com.amine.gestionpaie.repository.EmployeRepository;
import com.amine.gestionpaie.repository.PrimeNormalRepository;
import com.amine.gestionpaie.services.PrimeNormalServices;
import com.amine.gestionpaie.validators.*;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class PrimeNormalServiceImpl implements PrimeNormalServices{
	private PrimeNormalRepository primeNormalRepository;
	private EmployeRepository employeRepository;
	@Autowired
	public PrimeNormalServiceImpl(PrimeNormalRepository primeNormalRepository,EmployeRepository employeRepository) {
		
		this.primeNormalRepository = primeNormalRepository;
		this.employeRepository=employeRepository;
	}

	@Override
	public PrimeNormalDto save(PrimeNormalDto dto) {
		List<String> errors= PrimeNormalValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("Prime is not valid", dto);
			throw new InvalidEntityException("Prime n'est pas valide", ErrorCodes.PRIME_NOT_VALID,errors);
		}
		Optional<Employe> employe=employeRepository.findById(dto.getEmployePrime().getMatricule());
		if(employe.isEmpty()) {
			log.warn("Employe with ID {} was not found in the DB",dto.getEmployePrime().getMatricule());
			throw new EntityNotFoundException("aucun Employe avec l'ID "+dto.getEmployePrime().getMatricule()+"n'a ete trouve dans la DDB",ErrorCodes.EMPLOYE_NOT_FOUND);
		}
		return PrimeNormalDto.fromEntity(primeNormalRepository.save(PrimeNormalDto.toEntity(dto)));
	}

	@Override
	public PrimeNormalDto findById(Long id) {
		// TODO Auto-generated method stub
		if(id==null) {
			log.error("Prime ID is null");
			return null;
		}
		Optional<PrimeNormal> prime= primeNormalRepository.findById(id);
		PrimeNormalDto dto= PrimeNormalDto.fromEntity(prime.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucn Prime avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.PRIME_NOT_FOUND));
	}

	@Override
	public PrimeNormalDto findByNom(String nom) {
		// TODO Auto-generated method stub
		if(!StringUtils.hasLength(nom)) {
			log.error("Prime Nom is null");
			return null;
		}
		Optional<PrimeNormal> prime= primeNormalRepository.findPrimeByNomPrime(nom);
		PrimeNormalDto dto= PrimeNormalDto.fromEntity(prime.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucn prime avec le type ="+nom+"n'a ete trouve dans la base de données",ErrorCodes.PRIME_NOT_FOUND));
	}

	@Override
	public void delete(Long id) {
		if(id==null) {
			log.error("Prime ID is null");
			return;
		}
		primeNormalRepository.deleteById(id);
		
	}

	@Override
	public Collection<PrimeNormalDto> findByPrimeEmployeAndDate(Long idEmploye, Date date) {
		if(idEmploye==null) {
			log.error("contrat id employe is null");
			return null;
		}
		if(date==null) {
			log.error("contrat id employe is null");
			return null;
		}
		Collection<PrimeNormalDto> prime= primeNormalRepository.findPrimeByDateAndIdForBulletinPaie(idEmploye, date).stream().map(PrimeNormalDto::fromEntity).collect(Collectors.toList());
		
		return  prime;

	}

	@Override
	public Double calculSolePrime(Collection<PrimeNormalDto> prime) {
		Double some=null;
		for (PrimeNormalDto  prim : prime) {
			some=some+prim.getValeurPrime();
		}
		return some;
	}

	

}
