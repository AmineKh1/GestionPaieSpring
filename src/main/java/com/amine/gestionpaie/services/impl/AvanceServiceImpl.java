package com.amine.gestionpaie.services.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.gestionpaie.dto.*;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.Avance;
import com.amine.gestionpaie.model.Employe;
import com.amine.gestionpaie.model.Enfant;
import com.amine.gestionpaie.repository.AvanceRepository;
import com.amine.gestionpaie.repository.EmployeRepository;
import com.amine.gestionpaie.services.AvanceServices;
import com.amine.gestionpaie.validators.*;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class AvanceServiceImpl implements AvanceServices{
	private AvanceRepository avanceRepository;
	private EmployeRepository employeRepository;
	@Autowired
	public AvanceServiceImpl(AvanceRepository avanceRepository,EmployeRepository employeRepository) {
		this.avanceRepository = avanceRepository;
		this.employeRepository=employeRepository;
	}

	@Override
	public AvanceDto save(AvanceDto dto) {
		List<String> errors= AvanceValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("Avance is not valid", dto);
			throw new InvalidEntityException("Avance n'est pas valide", ErrorCodes.AVANCE_NOT_VALID,errors);
		}
		Optional<Employe> employe=employeRepository.findById(dto.getEmployeAvance().getMatricule());
		if(employe.isEmpty()) {
			log.warn("Employe with ID {} was not found in the DB",dto.getEmployeAvance().getMatricule());
			throw new EntityNotFoundException("aucun Employe avec l'ID "+dto.getEmployeAvance().getMatricule()+"n'a ete trouve dans la DDB",ErrorCodes.EMPLOYE_NOT_FOUND);
		}
		return AvanceDto.fromEntity(avanceRepository.save(AvanceDto.toEntity(dto)));
	}

	@Override
	public AvanceDto findById(Long id) {
		if(id==null) {
			log.error("Avance ID is null");
			return null;
		}
		Optional<Avance> avance= avanceRepository.findById(id);
		AvanceDto dto= AvanceDto.fromEntity(avance.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucun Avance avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.AVANCE_NOT_FOUND));
	}

	@Override
	public List<AvanceDto> findAll() {
		return avanceRepository.findAll().stream().map(AvanceDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		if(id==null) {
			log.error("Avance ID is null");
			return;
		}
		avanceRepository.deleteById(id);
		
	}

	@Override
	public Collection<AvanceDto> findByEmployeAvanceAndDateMoisA(Long idEmploye, Date date) {
		if(idEmploye==null) {
			log.error("contrat id employe is null");
			return null;
		}
		if(date==null) {
			log.error("contrat id employe is null");
			return null;
		}
		return avanceRepository.findAllByEmployeAvanceAndDateMoisA(idEmploye, date).stream().map(AvanceDto::fromEntity).collect(Collectors.toList());
	}

}
