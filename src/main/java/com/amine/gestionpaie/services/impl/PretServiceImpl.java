package com.amine.gestionpaie.services.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.gestionpaie.dto.ContratDto;
import com.amine.gestionpaie.dto.PretDto;
import com.amine.gestionpaie.dto.PrimeNormalDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.Contrat;
import com.amine.gestionpaie.model.Employe;
import com.amine.gestionpaie.model.Pret;
import com.amine.gestionpaie.repository.EmployeRepository;
import com.amine.gestionpaie.repository.PretRepository;
import com.amine.gestionpaie.services.PretServices;
import com.amine.gestionpaie.validators.*;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class PretServiceImpl implements PretServices{
	private PretRepository pretRepository;
	private EmployeRepository employeRepository;
	@Autowired
	public PretServiceImpl(PretRepository pretRepository,EmployeRepository employeRepository) {
		
		this.pretRepository = pretRepository;
		this.employeRepository=employeRepository;
	}

	@Override
	public PretDto save(PretDto dto) {
		List<String> errors= PretValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("Pret is not valid", dto);
			throw new InvalidEntityException("Pret n'est pas valide", ErrorCodes.PRET_NOT_VALID,errors);
		}
		Optional<Employe> employe=employeRepository.findById(dto.getEmployePret().getMatricule());
		if(employe.isEmpty()) {
			log.warn("Employe with ID {} was not found in the DB",dto.getEmployePret().getMatricule());
			throw new EntityNotFoundException("aucun Employe avec l'ID "+dto.getEmployePret().getMatricule()+"n'a ete trouve dans la DDB",ErrorCodes.EMPLOYE_NOT_FOUND);
		}
		return PretDto.fromEntity(pretRepository.save(PretDto.toEntity(dto)));

	}

	

	@Override
	public PretDto findById(Long id) {
		if(id==null) {
			log.error("pret ID is null");
			return null;
		}
		Optional<Pret> pret= pretRepository.findById(id);
		PretDto dto= PretDto.fromEntity(pret.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucun Pret avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.PRET_NOT_FOUND));

	}

	@Override
	public List<PretDto> findAll() {
		return pretRepository.findAll().stream().map(PretDto::fromEntity).collect(Collectors.toList());

	}

	@Override
	public void delete(Long id) {
		if(id==null) {
			log.error("Pret ID is null");
			return;
		}
		pretRepository.deleteById(id);
		
		
	}

	@Override
	public Collection<PretDto> findByPretEmployeAndDate(Long idEmploye, Date date) {
		if(idEmploye==null) {
			log.error("contrat id employe is null");
			return null;
		}
		if(date==null) {
			log.error("contrat id employe is null");
			return null;
		}
		Collection<PretDto> pret= pretRepository.findAllPretByDateAndIdForBulletinPaie(idEmploye, date).stream().map(PretDto::fromEntity).collect(Collectors.toList());
		
		return  pret;

	}
	

}
