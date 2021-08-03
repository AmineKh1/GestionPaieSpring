package com.amine.gestionpaie.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.gestionpaie.dto.*;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.anneeConfig.AMO;
import com.amine.gestionpaie.model.anneeConfig.CNSS;
import com.amine.gestionpaie.repository.CNSSRepository;
import com.amine.gestionpaie.services.CNSSServices;
import com.amine.gestionpaie.validators.AmoValidator;
import com.amine.gestionpaie.validators.CNSSValidator;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class CNSServiceImpl implements CNSSServices{
	private CNSSRepository cnssRepository;
	@Autowired
	public CNSServiceImpl(CNSSRepository cnssRepository) {
		this.cnssRepository = cnssRepository;
	}
	@Override
	public CNSSDto save(CNSSDto dto) {
		List<String> errors= CNSSValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("CNSS is not valid", dto);
			throw new InvalidEntityException("Amo n'est pas valide", ErrorCodes.CNSS_NOT_VALID,errors);
		}
		return CNSSDto.fromEntity(cnssRepository.save(CNSSDto.toEntity(dto)));

	}
	@Override
	public CNSSDto findById(Long id) {
		if(id==null) {
			log.error("CNSS ID is null");
			return null;
		}
		Optional<CNSS> cnss= cnssRepository.findById(id);
		CNSSDto dto= CNSSDto.fromEntity(cnss.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucun cnss avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.CNSS_NOT_FOUND));

	}
	@Override
	public CNSSDto findByAnnee(int annee) {
		if(annee==0) {
			log.error("cnss annee is null");
			return null;
		}
		Optional<CNSS> cnss= cnssRepository.findCnssByAnnees(annee);
		CNSSDto dto= CNSSDto.fromEntity(cnss.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucn CNSS avec l'annee ="+annee+"n'a ete trouve dans la base de données",ErrorCodes.CNSS_NOT_FOUND));

	}
	@Override
	public List<CNSSDto> findAll() {
		return cnssRepository.findAll().stream().map(CNSSDto::fromEntity).collect(Collectors.toList());

	}
	@Override
	public void delete(Long id) {
		if(id==null) {
			log.error("CNSS ID is null");
			return;
		}
		cnssRepository.deleteById(id);
		
	}
	@Override
	public Double calculSalaireCnss(CNSSDto cnss,Double salaire) {
		
		// TODO Auto-generated method stub
		Double sl;
		if(salaire<=cnss.getPlafondSalarialSP()) {
			sl=salaire*cnss.getTauxSalarialSP();
		}
		else {
			sl= cnss.getPlafondSalarialSP()*cnss.getTauxSalarialSP();
			
		}
		return sl;
	}


}
