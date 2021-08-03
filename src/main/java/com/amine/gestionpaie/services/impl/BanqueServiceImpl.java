package com.amine.gestionpaie.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.BanqueDto;
import com.amine.gestionpaie.dto.SocieteDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.Banque;
import com.amine.gestionpaie.model.Societe;
import com.amine.gestionpaie.repository.BanqueRepository;
import com.amine.gestionpaie.services.BanqueServices;
import com.amine.gestionpaie.validators.BanqueValidator;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class BanqueServiceImpl implements BanqueServices{
	private BanqueRepository banqueRepository;
	@Autowired
	public BanqueServiceImpl(BanqueRepository banqueRepository) {
		this.banqueRepository=banqueRepository;
	}
	@Override
	public BanqueDto save(BanqueDto dto) {
		List<String> errors= BanqueValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("Banque is not valid", dto);
			throw new InvalidEntityException("Banque n'est pas valide", ErrorCodes.BANQUE_NOT_VALID,errors);
		}
		return BanqueDto.fromEntity(banqueRepository.save(BanqueDto.toEntity(dto)));

	}

	@Override
	public BanqueDto findById(Long id) {
		if(id==null) {
			log.error("Banque ID is null");
			return null;
		}
		Optional<Banque> banque=banqueRepository.findById(id);
		BanqueDto dto=BanqueDto.fromEntity(banque.get());
		return Optional.of(dto).orElseThrow(()->new EntityNotFoundException("aucune Banque avec l'id ="+id+"n'a ete trouve dans la base de données",ErrorCodes.BANQUE_NOT_VALID)) ;
	}

	@Override
	public BanqueDto findByNomBanque(String nomBanque) {
		if(!StringUtils.hasLength(nomBanque)) {
			log.error("Banque Nom is null");
			return null;
		}
		Optional<Banque> banque= banqueRepository.findByNomBanque(nomBanque);
		BanqueDto dto= BanqueDto.fromEntity(banque.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucn societe avec le nom ="+nomBanque+"n'a ete trouve dans la base de données",ErrorCodes.BANQUE_NOT_FOUND));
	}

	@Override
	public List<BanqueDto> findAll() {
		return banqueRepository.findAll().stream().map(BanqueDto::fromEntity).collect(Collectors.toList());

	}

	@Override
	public void delete(Long id) {
		if(id==null) {
			log.error("Banque ID is null");
			return;
		}
		banqueRepository.deleteById(id);
		
		
	}

}
