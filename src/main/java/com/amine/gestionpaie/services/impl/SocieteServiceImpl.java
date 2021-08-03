package com.amine.gestionpaie.services.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.DepartementDto;
import com.amine.gestionpaie.dto.RolesDto;
import com.amine.gestionpaie.dto.SocieteDto;
import com.amine.gestionpaie.dto.UtilisateurDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.Departement;
import com.amine.gestionpaie.model.Societe;
import com.amine.gestionpaie.repository.RolesRepository;
import com.amine.gestionpaie.repository.SocieteRepository;
import com.amine.gestionpaie.services.SocieteServices;
import com.amine.gestionpaie.services.UtilisateurServices;
import com.amine.gestionpaie.validators.SocieteValidator;


import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class SocieteServiceImpl implements SocieteServices{
	private UtilisateurServices utilisateurService;
	private SocieteRepository societeRepository;
	private RolesRepository rolesRepository;
	@Autowired
	public SocieteServiceImpl(SocieteRepository societeRepository,UtilisateurServices utilisateurService,RolesRepository rolesRepository) {
		this.societeRepository=societeRepository;
		this.utilisateurService=utilisateurService;
		this.rolesRepository=rolesRepository;
	}
	@Override
	public SocieteDto save(SocieteDto dto) {
		// TODO Auto-generated method stub
		List<String> errors= SocieteValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("Societe is not valid", dto);
			throw new InvalidEntityException("societe n'est pas valide", ErrorCodes.SOCIETE_NOT_VALID,errors);
		}
		SocieteDto savedSociete = SocieteDto.fromEntity(societeRepository.save(SocieteDto.toEntity(dto)));
		
		UtilisateurDto utilisateur=fromSociete(savedSociete);
		UtilisateurDto savedUser= utilisateurService.save(utilisateur);
		RolesDto rolesDto=RolesDto.builder()
				.roleName("ADMIN")
				.utilisateur(savedUser)
				.build();
		rolesRepository.save(RolesDto.toEntity(rolesDto));
				return savedSociete;
	}
	private UtilisateurDto fromSociete(SocieteDto dto) {
	    return UtilisateurDto.builder()
	        .email(dto.getEmailSociete())
	        .mdp(generateRandomPassword())
	        
	        .build();
	  }
	private String generateRandomPassword() {
		// TODO Auto-generated method stub
		return "som3R@nd0mP@$$word";
	}
	@Override
	public SocieteDto findById(Long id) {
		if(id==null) {
			log.error("Societe ID is null");
			return null;
		}
		Optional<Societe> societe= societeRepository.findById(id);
		SocieteDto dto= SocieteDto.fromEntity(societe.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucn societe avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.SOCIETE_NOT_FOUND));
	}

	@Override
	public SocieteDto findByNomSociete(String nomSociete) {
		// TODO Auto-generated method stub
		if(!StringUtils.hasLength(nomSociete)) {
			log.error("Societe Nom is null");
			return null;
		}
		Optional<Societe> societe= societeRepository.findSocieteByNomSociete(nomSociete);
		SocieteDto dto= SocieteDto.fromEntity(societe.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucn societe avec le nom ="+nomSociete+"n'a ete trouve dans la base de données",ErrorCodes.SOCIETE_NOT_FOUND));
	}

	@Override
	public List<SocieteDto> findAll() {
		// TODO Auto-generated method stub
		return societeRepository.findAll().stream().map(SocieteDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		if(id==null) {
			log.error("Societe ID is null");
			return;
		}
		societeRepository.deleteById(id);
	}
	
	
	
	
	

}
