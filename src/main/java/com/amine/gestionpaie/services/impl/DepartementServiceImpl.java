package com.amine.gestionpaie.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.gestionpaie.dto.DepartementDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.*;
import com.amine.gestionpaie.repository.DepartementRepository;
import com.amine.gestionpaie.repository.SocieteRepository;
import com.amine.gestionpaie.services.DepartementServices;
import com.amine.gestionpaie.validators.DepartementValidator;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class DepartementServiceImpl implements DepartementServices{
	private DepartementRepository departementRepository;
	private SocieteRepository societeRepository;
	
	@Autowired
	public DepartementServiceImpl(DepartementRepository departementRepository, SocieteRepository societeRepository) {
		this.departementRepository = departementRepository;
		this.societeRepository = societeRepository;
	}

	@Override
	public DepartementDto save(DepartementDto dto) {
		List<String> errors= DepartementValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("Departement is not valid",dto);
			throw new InvalidEntityException("Departement n'est pas valide",ErrorCodes.DEPARTEMENT_NOT_VALID,errors);
			
		}
		Optional<Societe> societe=societeRepository.findById(dto.getSociete().getIdSociete());
		if(societe.isEmpty()) {
			log.warn("Societe with ID {} was not found in the DB",dto.getSociete().getIdSociete());
			throw new EntityNotFoundException("aucun Societe avec l'ID"+dto.getSociete().getIdSociete());
			
		}
		return DepartementDto.fromEntity(departementRepository.save(DepartementDto.toEntity(dto)));
	}

	@Override
	public DepartementDto findById(Long id) {
		if(id==null) {
			log.error("Departement ID is null");
			return null;
		}
		Optional<Departement> departement= departementRepository.findById(id);
		DepartementDto dto= DepartementDto.fromEntity(departement.get());
		return Optional.of(dto).orElseThrow(()-> new EntityNotFoundException("aucun Departement avec L'ID="+id+"n'a ete trouve dans la base de données",ErrorCodes.DEPARTEMENT_NOT_FOUND));
		
	}

	/*@Override
	public DepartementDto findByIdSociete(Long id) {
		if(id==null) {
			log.error("Societe id is null");
			return null;
		}
		Optional<Departement> departement=departementRepository.findBySocieteIdSociete(id);
		DepartementDto dto= DepartementDto.fromEntity(departement.get());
		return Optional.of(dto).orElseThrow(()-> new EntityNotFoundException("aucun Departement avec id de societe="+id+"n'a ete trouve dans la base de données",ErrorCodes.DEPARTEMENT_NOT_FOUND));
		
	}*/

	@Override
	public List<DepartementDto> findAll() {
		return departementRepository.findAll().stream().map(DepartementDto::fromEntity).collect(Collectors.toList());
		
	}

	@Override
	public void delete(Long id) {
		if(id==null) {
			log.error("Departemet ID is null");
			return;
		}
		departementRepository.deleteById(id);
		
	}

	@Override
	public List<DepartementDto> findAllByIdSociete(Long idSociete) {
		// TODO Auto-generated method stub
		if(idSociete==null) {
			log.error("Societe ID is null");
			return null;
		}
		Optional<Societe> societe=societeRepository.findById(idSociete);
		Optional<Departement> departement=departementRepository.findBySocieteIdSociete(idSociete);

		if(societe.isEmpty()) {
			log.warn("Societe with ID {} was not found in the DB", idSociete);
			throw new EntityNotFoundException("aucun Societe avec l'ID"+idSociete+"n'a ete trouvez dans la BBD",ErrorCodes.SOCIETE_NOT_FOUND);
		}
		if(departement.isEmpty()) {
			log.warn("Departement Societe with ID {} was not found in the DB", idSociete);
			throw new EntityNotFoundException("aucun Departement avec id de societe="+idSociete+"n'a ete trouve dans la base de données",ErrorCodes.DEPARTEMENT_NOT_FOUND);
		}
		return departementRepository.findAllBySociete(idSociete).stream().map(DepartementDto::fromEntity).collect(Collectors.toList());
	}

}
