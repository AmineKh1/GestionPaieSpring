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
import com.amine.gestionpaie.model.Societe;
import com.amine.gestionpaie.model.anneeConfig.Anciennete;
import com.amine.gestionpaie.model.anneeConfig.AncienneteList;
import com.amine.gestionpaie.repository.AncienneteListRepository;
import com.amine.gestionpaie.repository.AncienneteRepository;
import com.amine.gestionpaie.services.AncieneteServices;
import com.amine.gestionpaie.validators.AncienneteListValidator;
import com.amine.gestionpaie.validators.AncienneteValidator;
import com.amine.gestionpaie.validators.SocieteValidator;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class AncienneteServiceImpl implements AncieneteServices{
	private AncienneteRepository ancienneteRepository;
	private AncienneteListRepository ancienneteListRepository;
	@Autowired
	public AncienneteServiceImpl(AncienneteRepository ancienneteRepository,AncienneteListRepository ancienneteListRepository) {
		
		this.ancienneteRepository = ancienneteRepository;
		this.ancienneteListRepository=ancienneteListRepository;
	}
	@Override
	public AncienneteDto save(AncienneteDto dto) {
		// TODO Auto-generated method stub
		List<String> errors= AncienneteValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("Annee anciennete is not valid", dto);
			throw new InvalidEntityException("annee anciennete n'est pas valide", ErrorCodes.ANCIENNETE_NOT_VALID,errors);
		}
		List<String> errorsList= AncienneteListValidator.validate(dto.getAncienneteListDto());
		if(!errorsList.isEmpty()) {
			log.error("anciennete parametere est vide");
			throw new InvalidEntityException("parametre n'est pas valide",ErrorCodes.ANCIENNETE_PARAMETRE_NOT_VALID,errors);
		}
		Anciennete savedAnciennete =ancienneteRepository.save(AncienneteDto.toEntity(dto));
		dto.getAncienneteListDto().forEach(anciennete->{
			AncienneteList ancienneteList = AncienneteListDto.toEntity(anciennete);
			ancienneteList.setAnciennete(savedAnciennete);
			ancienneteListRepository.save(ancienneteList);
		});
		return AncienneteDto.fromEntity(savedAnciennete);
	}
	@Override
	public AncienneteDto findById(Long id) {
		if(id==null) {
			log.error("Annee anciennete ID is null");
			return null;
		}
		Optional<Anciennete> anciennete= ancienneteRepository.findById(id);
		AncienneteDto dto= AncienneteDto.fromEntity(anciennete.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucun anciennete annee avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.ANCIENNETE_NOT_FOUND));
	}
	@Override
	public AncienneteDto findByAnnee(int annee) {
		if(annee==0) {
			log.error("annee Anciennete is null");
			return null;
		}
		Optional<Anciennete> anciennete= ancienneteRepository.findAncienneteByAnnees(annee);
		AncienneteDto dto= AncienneteDto.fromEntity(anciennete.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucn anciennete annee avec le nom ="+annee+"n'a ete trouve dans la base de données",ErrorCodes.ANCIENNETE_NOT_FOUND));
	}
	@Override
	public List<AncienneteDto> findAll() {
		return ancienneteRepository.findAll().stream().map(AncienneteDto::fromEntity).collect(Collectors.toList());
	}
	@Override
	public void delete(Long id) {
		if(id==null) {
			log.error("Anciennete annee ID is null");
			return;
		}
		ancienneteRepository.deleteById(id);		
	}

	





}
