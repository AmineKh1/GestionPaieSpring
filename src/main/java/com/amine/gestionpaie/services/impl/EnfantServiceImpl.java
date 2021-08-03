package com.amine.gestionpaie.services.impl;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.EnfantDto;
import com.amine.gestionpaie.dto.SocieteDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.Employe;
import com.amine.gestionpaie.model.Enfant;
import com.amine.gestionpaie.model.Societe;
import com.amine.gestionpaie.repository.EmployeRepository;
import com.amine.gestionpaie.repository.EnfantRepository;
import com.amine.gestionpaie.services.EnfantServices;
import com.amine.gestionpaie.validators.EnfantValidator;
import com.amine.gestionpaie.validators.SocieteValidator;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class EnfantServiceImpl implements EnfantServices{
	private EnfantRepository enfantRepository;
	private EmployeRepository employeRepository;
	
	@Autowired
	public EnfantServiceImpl(EnfantRepository enfantRepository,EmployeRepository employeRepository) {
		this.enfantRepository = enfantRepository;
		this.employeRepository=employeRepository;
	}

	@Override
	public EnfantDto save(EnfantDto dto) {
		List<String> errors= EnfantValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("Enfant is not valid", dto);
			throw new InvalidEntityException("enfant n'est pas valide", ErrorCodes.ENFANT_NOT_VALID,errors);
		}
		Optional<Employe> employe=employeRepository.findById(dto.getEmployeEnfant().getMatricule());
		if(employe.isEmpty()) {
			log.warn("Employe with ID {} was not found in the DB",dto.getEmployeEnfant().getMatricule());
			throw new EntityNotFoundException("aucun Employe avec l'ID "+dto.getEmployeEnfant().getMatricule()+"n'a ete trouve dans la DDB",ErrorCodes.EMPLOYE_NOT_FOUND);
		}
		return EnfantDto.fromEntity(enfantRepository.save(EnfantDto.toEntity(dto)));
	}

	@Override
	public EnfantDto findById(Long id) {
		if(id==null) {
			log.error("Enfant ID is null");
			return null;
		}
		Optional<Enfant> enfant= enfantRepository.findById(id);
		EnfantDto dto= EnfantDto.fromEntity(enfant.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucun enfant avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.ENFANT_NOT_FOUND));
	}

	@Override
	public List<EnfantDto> findAll() {
		return enfantRepository.findAll().stream().map(EnfantDto::fromEntity).collect(Collectors.toList());

	}

	@Override
	public void delete(Long id) {
		if(id==null) {
			log.error("Enfant ID is null");
			return;
		}
		enfantRepository.deleteById(id);
	}

	@Override
	public Collection<EnfantDto> findAllByIdEmployeEnfant(Long idEmploye) {
		// TODO Auto-generated method stub
		return enfantRepository.findAllByEmployeEnfant(idEmploye).stream().map(EnfantDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public int findMineur(Collection<EnfantDto> enfants,Date dateB) {
		// TODO Auto-generated method stub
		   int set=0;
		
		for(EnfantDto enfant: enfants) {
			long age = ChronoUnit.YEARS.between((Temporal) enfant.getDatedeNaissance(), (Temporal) dateB);
			if (age<18) {
				set=set+1;
			}
		}
		return set;
	}

}
