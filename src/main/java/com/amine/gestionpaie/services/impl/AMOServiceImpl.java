package com.amine.gestionpaie.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.AMODto;
import com.amine.gestionpaie.dto.ContratDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.Contrat;
import com.amine.gestionpaie.model.anneeConfig.AMO;
import com.amine.gestionpaie.repository.AMORepository;
import com.amine.gestionpaie.services.AMOServices;
import com.amine.gestionpaie.validators.*;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class AMOServiceImpl implements AMOServices{
	private AMORepository amoRepository;
	
	@Autowired
	public AMOServiceImpl(AMORepository amoReposiotry) {
		this.amoRepository = amoReposiotry;
	}

	@Override
	public AMODto save(AMODto dto) {
		List<String> errors= AmoValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("Amo is not valid", dto);
			throw new InvalidEntityException("Amo n'est pas valide", ErrorCodes.AMO_NOT_VALID,errors);
		}
		return AMODto.fromEntity(amoRepository.save(AMODto.toEntity(dto)));

	}

	@Override
	public AMODto findById(Long id) {
		if(id==null) {
			log.error("AMO ID is null");
			return null;
		}
		Optional<AMO> amo= amoRepository.findById(id);
		AMODto dto= AMODto.fromEntity(amo.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucun amo avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.AMO_NOT_FOUND));

	}

	@Override
	public AMODto findByAnnee(int annee) {
		if(annee==0) {
			log.error("contrat type is null");
			return null;
		}
		Optional<AMO> amo= amoRepository.findContratByAnnees(annee);
		AMODto dto= AMODto.fromEntity(amo.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucn amo avec l'annee ="+annee+"n'a ete trouve dans la base de données",ErrorCodes.AMO_NOT_FOUND));

	}

	@Override
	public List<AMODto> findAll() {
		return amoRepository.findAll().stream().map(AMODto::fromEntity).collect(Collectors.toList());

	}

	@Override
	public void delete(Long id) {
		if(id==null) {
			log.error("AMO ID is null");
			return;
		}
		amoRepository.deleteById(id);
		
	}

	@Override
	public Double calculSalaireAmo(AMODto amo, Double salaireBase) {
		// TODO Auto-generated method stub
		Double sl;
		sl=salaireBase*amo.getTauxAmoSalarial();
		return sl;
	}

	


}
