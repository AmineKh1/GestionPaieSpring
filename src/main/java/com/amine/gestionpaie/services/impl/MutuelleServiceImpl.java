package com.amine.gestionpaie.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.gestionpaie.dto.AMODto;
import com.amine.gestionpaie.dto.MutuelleDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.anneeConfig.AMO;
import com.amine.gestionpaie.model.anneeConfig.Mutuelle;
import com.amine.gestionpaie.repository.MutuelleRepository;
import com.amine.gestionpaie.services.MutuelleServices;
import com.amine.gestionpaie.validators.*;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class MutuelleServiceImpl implements MutuelleServices{
	private MutuelleRepository mutuelleRepository;
	@Autowired
	public MutuelleServiceImpl(MutuelleRepository mutuelleRepository) {
			this.mutuelleRepository = mutuelleRepository;
		}

	@Override
	public MutuelleDto save(MutuelleDto dto) {
		List<String> errors= MutuelleValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("Mutuelle is not valid", dto);
			throw new InvalidEntityException("Mutuelle n'est pas valide", ErrorCodes.MUTUELLE_NOT_VALID,errors);
		}
		return MutuelleDto.fromEntity(mutuelleRepository.save(MutuelleDto.toEntity(dto)));

	}

	
	@Override
	public MutuelleDto findById(Long id) {
		if(id==null) {
			log.error("Mutulle ID is null");
			return null;
		}
		Optional<Mutuelle> mutuelle= mutuelleRepository.findById(id);
		MutuelleDto dto= MutuelleDto.fromEntity(mutuelle.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucun Mutulle avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.MUTUELLE_NOT_FOUND));

	}

	@Override
	public MutuelleDto findByAnnee(int annee) {
		if(annee==0) {
			log.error("contrat type is null");
			return null;
		}
		Optional<Mutuelle> mutuelle= mutuelleRepository.findMutuelleByAnnees(annee);
		MutuelleDto dto= MutuelleDto.fromEntity(mutuelle.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucn Mutuelle avec l'annee ="+annee+"n'a ete trouve dans la base de données",ErrorCodes.MUTUELLE_NOT_FOUND));

	}

	@Override
	public List<MutuelleDto> findAll() {
		// TODO Auto-generated method stub
		return mutuelleRepository.findAll().stream().map(MutuelleDto::fromEntity).collect(Collectors.toList());

	}

	@Override
	public void delete(Long id) {
		if(id==null) {
			log.error("Mutuelle ID is null");
			return;
		}
		mutuelleRepository.deleteById(id);
		
		
	}
	

}
