package com.amine.gestionpaie.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.ContratDto;
import com.amine.gestionpaie.dto.EmployeDto;
import com.amine.gestionpaie.dto.SmicDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.Conge;
import com.amine.gestionpaie.model.Contrat;
import com.amine.gestionpaie.model.Employe;
import com.amine.gestionpaie.model.anneeConfig.Smic;
import com.amine.gestionpaie.repository.*;
import com.amine.gestionpaie.services.ContratServices;
import com.amine.gestionpaie.validators.*;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContratServiceImpl implements ContratServices{
	private ContratRepository contratRepository;
	private EmployeRepository employeRepository;
	private SmicRepository smicRepository;
	@Autowired
	public ContratServiceImpl(ContratRepository contratReposiotry, EmployeRepository employeRepository,SmicRepository smicRepository) {
		this.contratRepository = contratReposiotry;
		this.employeRepository=employeRepository;
		this.smicRepository=smicRepository;
	}

	@Override
	public ContratDto save(ContratDto dto) {
		Optional<Smic> smic= smicRepository.findSmicByAnnees(LocalDateTime.now().getYear());
		List<String> errors= ContratValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("Contrat is not valid", dto);
			throw new InvalidEntityException("Contrat n'est pas valide", ErrorCodes.CONTRAT_NOT_VALID,errors);
		}
		Optional<Employe> employe=employeRepository.findById(dto.getEmployeContrat().getMatricule());
		if(employe.isEmpty()) {
			log.warn("Employe with ID {} was not found in the DB",dto.getEmployeContrat().getMatricule());
			throw new EntityNotFoundException("aucun Employe avec l'ID"+dto.getEmployeContrat().getMatricule());
		}
		if(dto.getSalaireBase()<smic.get().getValeurSmig()) {
			log.warn("value of salaire {} not valid ",dto.getSalaireBase());
			throw new EntityNotFoundException("le salaire du base "+dto.getSalaireBase()+" est mois le smic du country"+smic.get().getValeurSmig());
		}
		return ContratDto.fromEntity(contratRepository.save(ContratDto.toEntity(dto)));

	}

	@Override
	public ContratDto findById(Long id) {
		if(id==null) {
			log.error("Contrat ID is null");
			return null;
		}
		Optional<Contrat> contrat= contratRepository.findById(id);
		ContratDto dto= ContratDto.fromEntity(contrat.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucun contrat avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.CONTRAT_NOT_FOUND));

	}

	@Override
	public ContratDto findByType(String type) {
		if(!StringUtils.hasLength(type)) {
			log.error("contrat type is null");
			return null;
		}
		Optional<Contrat> contrat= contratRepository.findContratByTypeContrat(type);
		ContratDto dto= ContratDto.fromEntity(contrat.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucn contrat avec le type ="+type+"n'a ete trouve dans la base de données",ErrorCodes.CONTRAT_NOT_FOUND));
	}

	@Override
	public List<ContratDto> findAll() {
		return contratRepository.findAll().stream().map(ContratDto::fromEntity).collect(Collectors.toList());

	}

	@Override
	public void delete(Long id) {
		if(id==null) {
			log.error("Contrat ID is null");
			return;
		}
		contratRepository.deleteById(id);
		
	}

	@Override
	public ContratDto findByProfession(String profession) {
		if(!StringUtils.hasLength(profession)) {
			log.error("contrat profession is null");
			return null;
		}
		Optional<Contrat> contrat= contratRepository.findContratByProfession(profession);
		ContratDto dto= ContratDto.fromEntity(contrat.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucn contrat avec le profession ="+profession+"n'a ete trouve dans la base de données",ErrorCodes.CONTRAT_NOT_FOUND));

	}

	@Override
	public ContratDto findByEmployeContratAndDate(Long idEmploye, Date date) {
		if(idEmploye==null) {
			log.error("contrat id employe is null");
			return null;
		}
		if(date==null) {
			log.error("contrat id employe is null");
			return null;
		}
		Optional<Contrat> contrat= contratRepository.findContratByDateAndIdForBulletinPaie(idEmploye, date);
		ContratDto dto= ContratDto.fromEntity(contrat.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucun contrat avec l'id employe ="+idEmploye+"sur la date d'embauche"+date+"n'a ete trouve dans la base de données",ErrorCodes.CONTRAT_NOT_FOUND));

	}
	@Override
	public Long CalculeAnciennete(Date date,Date dateBulletin) {
		Long calcul;
		calcul = ChronoUnit.YEARS.between(LocalDate.of(date.getYear(),date.getMonth(),date.getDay()), LocalDate.of(dateBulletin.getYear(), dateBulletin.getMonth(), dateBulletin.getDay()));
		return calcul;
	}
	

}
