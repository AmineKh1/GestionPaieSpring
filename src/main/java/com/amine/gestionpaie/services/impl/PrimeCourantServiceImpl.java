package com.amine.gestionpaie.services.impl;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.amine.gestionpaie.dto.PrimeCourantDto;
import com.amine.gestionpaie.dto.PrimeCourantListDto;
import com.amine.gestionpaie.dto.PrimeNormalDto;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.PrimeCourant;
import com.amine.gestionpaie.model.PrimeCourantList;
import com.amine.gestionpaie.repository.PrimeCourantListRepository;
import com.amine.gestionpaie.repository.PrimeCourantRepository;
import com.amine.gestionpaie.services.PrimeCourantServices;
import com.amine.gestionpaie.validators.PrimeCourantListValidator;
import com.amine.gestionpaie.validators.PrimeCourantValidator;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class PrimeCourantServiceImpl implements PrimeCourantServices{
	private PrimeCourantRepository primeCourantRepository;
	private PrimeCourantListRepository primeCourantListRepository;
	@Override
	public PrimeCourantDto save(PrimeCourantDto dto) {
		List<String> errors = PrimeCourantValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("Prime is not valid",dto);
			throw new InvalidEntityException("prime n'est pas valide",ErrorCodes.PRIME_NOT_VALID,errors);
		}
		List<String> errorsList= PrimeCourantListValidator.validate((PrimeCourantListDto) dto.getPrimeCourantList());
		if(!errorsList.isEmpty()) {
			log.error("etat du prime est pas valide");
			throw new InvalidEntityException("etat du prime n'est pas valide",ErrorCodes.PRIME_NOT_VALID,errors);
		}
		PrimeCourant savedPrime=primeCourantRepository.save(PrimeCourantDto.toEntity(dto));
		dto.getPrimeCourantList().forEach(prime ->{
			PrimeCourantList primeCourantList= PrimeCourantListDto.toEntity(prime);
			primeCourantList.setCollectionPrimeCourant(savedPrime);
			primeCourantListRepository.save(primeCourantList);
		});
		return PrimeCourantDto.fromEntity(savedPrime);
	}

	@Override
	public PrimeCourantDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimeCourantDto findByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<PrimeCourantDto> findByPrimeEmployeAndDate(Long idEmploye, Date date) {
		if(idEmploye==null) {
			log.error("contrat id employe is null");
			return null;
		}
		if(date==null) {
			log.error("contrat id employe is null");
			return null;
		}
		Collection<PrimeCourantDto> primepure=null;
		Collection<PrimeCourantDto> prime= primeCourantRepository.findAllByEmployePrime(idEmploye).stream().map(PrimeCourantDto::fromEntity).collect(Collectors.toList());
		prime.forEach(primeCase->{
			PrimeCourantList primeList = primeCourantListRepository.findByCollectionPrimeCourantAndDate(PrimeCourantDto.toEntity(primeCase).getIdPrime(), date);
			if(primeList==null) {
				primeList = primeCourantListRepository.findByCollectionPrimeCourant(PrimeCourantDto.toEntity(primeCase).getIdPrime());
			}
			if(primeList.getExist()==true) {
			primepure.add(PrimeCourantDto.fromEntity(primeList.getCollectionPrimeCourant()));
			}
		});
		return  primepure;

	}

	@Override
	public Double calculSolePrime(Collection<PrimeCourantDto> prime) {
		// TODO Auto-generated method stub
		Double some=null;
		for (PrimeCourantDto  prim : prime) {
			some=some+prim.getValeurPrime();
		}
		return some;
	}
	

}
