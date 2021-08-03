package com.amine.gestionpaie.services.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.gestionpaie.dto.CreditDto;
import com.amine.gestionpaie.dto.SocieteDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.Credit;
import com.amine.gestionpaie.model.Employe;
import com.amine.gestionpaie.model.Societe;
import com.amine.gestionpaie.repository.CreditRepository;
import com.amine.gestionpaie.repository.EmployeRepository;
import com.amine.gestionpaie.services.CreditServices;
import com.amine.gestionpaie.validators.CreditValidator;
import com.amine.gestionpaie.validators.SocieteValidator;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class CreditServiceImpl implements CreditServices{
	private CreditRepository creditRepository;
	private EmployeRepository employeRepository;
	@Autowired
	public CreditServiceImpl(CreditRepository creditRepository, EmployeRepository employeRepository) {
		
		this.creditRepository = creditRepository;
		this.employeRepository=employeRepository;
	}

	@Override
	public CreditDto save(CreditDto dto) {
		List<String> errors= CreditValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("Credit is not valid", dto);
			throw new InvalidEntityException("Credit n'est pas valide", ErrorCodes.CREDIT_NOT_VALID,errors);
		}
		Optional<Employe> employe=employeRepository.findById(dto.getEmployeCredit().getMatricule());
		if(employe.isEmpty()) {
			log.warn("Employe with ID {} was not found in the DB",dto.getEmployeCredit().getMatricule());
			throw new EntityNotFoundException("aucun Employe avec l'ID "+dto.getEmployeCredit().getMatricule()+"n'a ete trouve dans la DDB",ErrorCodes.EMPLOYE_NOT_FOUND);
		}
		return CreditDto.fromEntity(creditRepository.save(CreditDto.toEntity(dto)));
	}

	

	@Override
	public CreditDto findById(Long id) {
		if(id==null) {
			log.error("Credit ID is null");
			return null;
		}
		Optional<Credit> credit= creditRepository.findById(id);
		CreditDto dto= CreditDto.fromEntity(credit.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucn credit avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.CREDIT_NOT_FOUND));
	}

	@Override
	public List<CreditDto> findAll() {
		// TODO Auto-generated method stub
		return creditRepository.findAll().stream().map(CreditDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		if(id==null) {
			log.error("credit ID is null");
			return;
		}
		creditRepository.deleteById(id);
	}

	@Override
	public Collection<CreditDto> findAllByIdEmployeAndDate(Long idEmploye,Date date) {
		// TODO Auto-generated method stub
		if(idEmploye==null) {
			log.error("contrat id employe is null");
			return null;
		}
		if(date==null) {
			log.error("contrat id employe is null");
			return null;
		}
		return creditRepository.findAllByEmployeCreditAndDateAffectation(idEmploye,date).stream().map(CreditDto::fromEntity).collect(Collectors.toList());
	}

}
