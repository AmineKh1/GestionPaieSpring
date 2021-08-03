package com.amine.gestionpaie.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.PrimeNormalDto;
import com.amine.gestionpaie.dto.SocieteDto;
import com.amine.gestionpaie.dto.UtilisateurDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.Societe;
import com.amine.gestionpaie.model.utilisateurs.Utilisateur;
import com.amine.gestionpaie.repository.UtilisateurRepository;
import com.amine.gestionpaie.services.UtilisateurServices;
import com.amine.gestionpaie.validators.SocieteValidator;
import com.amine.gestionpaie.validators.UtilisateurValidator;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurServices{
	private UtilisateurRepository utilisateurRepository;
	private PasswordEncoder passwordEncoder;
	@Autowired
	public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
		
		this.utilisateurRepository = utilisateurRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UtilisateurDto save(UtilisateurDto dto) {
		List<String> errors= UtilisateurValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("Utilisateur is not valid", dto);
			throw new InvalidEntityException("Utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID,errors);
		}
		dto.setMdp(this.passwordEncoder.encode(dto.getMdp()));
		return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(dto)));
	}

	

	@Override
	public UtilisateurDto findById(Long id) {
		if(id==null) {
			log.error("Utilisateur ID is null");
			return null;
		}
		Optional<Utilisateur> utilisateur= utilisateurRepository.findById(id);
		UtilisateurDto dto= UtilisateurDto.fromEntity(utilisateur.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucn utilisateur avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.UTILISATEUR_NOT_FOUND));
	}

	@Override
	public UtilisateurDto findByEmail(String email) {
		if(!StringUtils.hasLength(email)) {
			log.error("Utilisateur email is null");
			return null;
		}
		Optional<Utilisateur> utilisateur= utilisateurRepository.findUtilisateurByEmail(email);
		UtilisateurDto dto= UtilisateurDto.fromEntity(utilisateur.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucun utilisateur avec l'email ="+email+"n'a ete trouve dans la base de données",ErrorCodes.UTILISATEUR_NOT_FOUND));
	
	}

	@Override
	public void delete(Long id) {
		if(id==null) {
			log.error("Utilisateur ID is null");
			return;
		}
		utilisateurRepository.deleteById(id);		
	}

	@Override
	public List<UtilisateurDto> findAll() {
		return utilisateurRepository.findAll().stream().map(UtilisateurDto::fromEntity).collect(Collectors.toList());

	}

}
