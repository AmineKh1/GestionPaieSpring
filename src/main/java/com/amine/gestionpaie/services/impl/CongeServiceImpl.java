package com.amine.gestionpaie.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.Conge;
import com.amine.gestionpaie.model.Employe;
import com.amine.gestionpaie.model.Enfant;
import com.amine.gestionpaie.repository.CongeRepository;
import com.amine.gestionpaie.repository.EmployeRepository;
import com.amine.gestionpaie.services.CongeServices;
import com.amine.gestionpaie.validators.*;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class CongeServiceImpl implements CongeServices{
	private CongeRepository congeRepository;
	private EmployeRepository employeRepository;
	
	
	@Autowired
	public CongeServiceImpl(CongeRepository congeReposiotry,EmployeRepository employeRepository) {
		this.congeRepository = congeReposiotry;
		this.employeRepository=employeRepository;
	}

	@Override
	public CongeDto save(CongeDto dto) {
		List<String> errors= CongeValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("Conge is not valid", dto);
			throw new InvalidEntityException("conge n'est pas valide", ErrorCodes.CONGE_NOT_VALID,errors);
		}
		Optional<Employe> employe=employeRepository.findById(dto.getEmployeConge().getMatricule());
		if(employe.isEmpty()) {
			log.warn("Employe with ID {} was not found in the DB",dto.getEmployeConge().getMatricule());
			throw new EntityNotFoundException("aucun Employe avec l'ID "+dto.getEmployeConge().getMatricule()+"n'a ete trouve dans la DDB",ErrorCodes.EMPLOYE_NOT_FOUND);
		}
		return CongeDto.fromEntity(congeRepository.save(CongeDto.toEntity(dto)));
	}

	@Override
	public CongeDto findById(Long id) {
		if(id==null) {
			log.error("Conge ID is null");
			return null;
		}
		Optional<Conge> conge= congeRepository.findById(id);
		CongeDto dto= CongeDto.fromEntity(conge.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucun Conge avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.CONGE_NOT_FOUND));
	}

	@Override
	public CongeDto findByType(String type) {
		if(!StringUtils.hasLength(type)) {
			log.error("conge type is null");
			return null;
		}
		Optional<Conge> conge= congeRepository.findCongeByType(type);
		CongeDto dto= CongeDto.fromEntity(conge.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucune Conge avec le type ="+type+"n'a ete trouve dans la base de données",ErrorCodes.CONGE_NOT_FOUND));
	}

	@Override
	public List<CongeDto> findAll() {
		return congeRepository.findAll().stream().map(CongeDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		if(id==null) {
			log.error("Conge ID is null");
			return;
		}
		congeRepository.deleteById(id);
		
	}

}
