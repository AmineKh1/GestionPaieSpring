package com.amine.gestionpaie.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.EmployeDto;
import com.amine.gestionpaie.dto.SocieteDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.Banque;
import com.amine.gestionpaie.model.Departement;
import com.amine.gestionpaie.model.Employe;
import com.amine.gestionpaie.model.Societe;
import com.amine.gestionpaie.repository.BanqueRepository;
import com.amine.gestionpaie.repository.DepartementRepository;
import com.amine.gestionpaie.repository.EmployeRepository;
import com.amine.gestionpaie.repository.SocieteRepository;
import com.amine.gestionpaie.services.EmployeServices;
import com.amine.gestionpaie.validators.EmployeValidator;
import com.amine.gestionpaie.validators.SocieteValidator;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class EmployeServiceImpl implements EmployeServices{
	private EmployeRepository employeRepository;
	private SocieteRepository societeRepository;
	private BanqueRepository banqueRepository;
	private DepartementRepository departementRepository;
	
	@Autowired
	public EmployeServiceImpl(EmployeRepository employeRepository,SocieteRepository societeRepository,BanqueRepository banqueRepository,DepartementRepository departementRepository) {
		this.employeRepository = employeRepository;
		this.societeRepository=societeRepository;
		this.banqueRepository=banqueRepository;
		this.departementRepository=departementRepository;
	}

	@Override
	public EmployeDto save(EmployeDto dto) {
		List<String> errors= EmployeValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("Employe is not valid", dto);
			throw new InvalidEntityException("employe n'est pas valide", ErrorCodes.EMPLOYE_NOT_VALID,errors);
		}
		Optional<Societe> societe= societeRepository.findById(dto.getSociete().getIdSociete());
		if(societe.isEmpty()) {
			log.warn("Societe with ID {} was not found in the DB",dto.getSociete().getIdSociete());
			throw new EntityNotFoundException("aucun Societe avec l'ID"+dto.getSociete().getIdSociete()+"n'a ete trouve dans la BBD",ErrorCodes.SOCIETE_NOT_FOUND);
		}
		Optional<Banque> banque= banqueRepository.findById(dto.getBanque().getIdBanque());
		if(banque.isEmpty()) {
			log.warn("Banque with ID {} was not found in the DB",dto.getBanque().getIdBanque());
			throw new EntityNotFoundException("aucune Banque avec l'ID "+dto.getBanque().getIdBanque()+"n'a ete trouve dans la DDB",ErrorCodes.BANQUE_NOT_FOUND);
		}
		return EmployeDto.fromEntity(employeRepository.save(EmployeDto.toEntity(dto)));
	}

	@Override
	public EmployeDto findById(Long id) {
		if(id==null) {
			log.error("Employe ID is null");
			return null;
		}
		Optional<Employe> employe= employeRepository.findById(id);
		EmployeDto dto= EmployeDto.fromEntity(employe.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucun employe avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.EMPLOYE_NOT_FOUND));
	}

	@Override
	public EmployeDto findBycin(String cin) {
		if(!StringUtils.hasLength(cin)) {
			log.error("Societe Nom is null");
			return null;
		}
		Optional<Employe> employe= employeRepository.findEmployeByCin(cin);
		EmployeDto dto= EmployeDto.fromEntity(employe.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucn employe avec le cin ="+cin+"n'a ete trouve dans la base de données",ErrorCodes.EMPLOYE_NOT_FOUND));
	}

	@Override
	public List<EmployeDto> findAll() {
		return employeRepository.findAll().stream().map(EmployeDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		if(id==null) {
			log.error("Employe ID is null");
			return;
		}
		employeRepository.deleteById(id);
	}

	@Override
	public List<EmployeDto> findAllByIdSociete(Long idSociete) {
		// TODO Auto-generated method stub
		if(idSociete==null) {
			log.error("Societe ID is null");
			return null;
			}
		Optional<Societe> societe=societeRepository.findById(idSociete);
		if(societe.isEmpty()) {
			log.warn("Societe with ID {} was not found in the DB", idSociete);
			throw new EntityNotFoundException("aucun Societe avec l'ID"+idSociete+"n'a ete trouvez dans la BBD",ErrorCodes.SOCIETE_NOT_FOUND);
		}
		Optional<Employe> employe=employeRepository.findBySocieteIdSociete(idSociete);
		if(employe.isEmpty()) {
			log.warn("Employe in societe with ID {} was not found in the DB",idSociete);
			throw new EntityNotFoundException("aucun employe sur societe avec ID="+idSociete+"n'a ete trouvez dans la base de donnees");
		}
		return employeRepository.findAllBySociete(idSociete).stream().map(EmployeDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public List<EmployeDto> findAllByIdBanque(Long idBanque) {
		// TODO Auto-generated method stub
		if(idBanque==null) {
			log.error("Banque ID is Nnull");
			return null;
		}
		Optional<Banque> banque=banqueRepository.findById(idBanque);
		if(banque.isEmpty()) {
			log.warn("Banque with ID {} was not found in the BD",idBanque);
			throw new EntityNotFoundException("aucune Banque avec l'ID"+idBanque+"n'a ete trouvez dans la BDD");
			
		}
		Optional<Employe> employe=employeRepository.findByBanqueIdBanque(idBanque);
		if(employe.isEmpty()) {
			log.warn("Employe with Banque's ID {} was not found in the DB",idBanque);
			throw new EntityNotFoundException("aucun employe avec la banque avec l'ID"+idBanque+"n'a ete trouvez dans la BDD");
		}
		return employeRepository.findAllByBanque(idBanque).stream().map(EmployeDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public List<EmployeDto> findAllByIdDepartement(Long idDepartement) {
		// TODO Auto-generated method stub
		if(idDepartement==null) {
			log.error("Departement ID is Null");
			return null;
		}
		Optional<Departement> departement= departementRepository.findById(idDepartement);
		if(departement.isEmpty()) {
			log.warn("Departement with ID {} was not found in the BD",idDepartement);
			throw new EntityNotFoundException("aucun Departement avec l'ID"+idDepartement+"n'a ete trouvez dans la BDD");
		}
		Optional<Employe> employe= employeRepository.findByDepartementNumDep(idDepartement);
		if(employe.isEmpty()) {
			log.warn("Employe in Departement with ID {} was not found in the DB",idDepartement);
			throw new EntityNotFoundException("aucun employe sur departement avec l'ID"+idDepartement+"n'a ete trouvez das la BBD");
		}
		return employeRepository.findAllByDepartement(idDepartement).stream().map(EmployeDto::fromEntity).collect(Collectors.toList());
	}



}
