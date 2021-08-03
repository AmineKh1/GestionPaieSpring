package com.amine.gestionpaie.services.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.gestionpaie.dto.AncienneteListDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.model.anneeConfig.Anciennete;
import com.amine.gestionpaie.model.anneeConfig.AncienneteList;
import com.amine.gestionpaie.repository.AncienneteListRepository;
import com.amine.gestionpaie.repository.AncienneteRepository;
import com.amine.gestionpaie.services.AncienneteListServices;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class AncienneteListServiceImpl implements AncienneteListServices{
	private AncienneteRepository ancienneteRepository;
	private AncienneteListRepository ancienneteListRepository;

	
	
	@Autowired
	public AncienneteListServiceImpl(AncienneteRepository ancienneteRepository,
			AncienneteListRepository ancienneteListRepository) {

		this.ancienneteRepository = ancienneteRepository;
		this.ancienneteListRepository = ancienneteListRepository;
	}

	@Override
	public AncienneteListDto findById(Long id) {
		if(id==null) {
			log.error("Anciennete setting ID's null");
			return null;
		}
		Optional<AncienneteList> ancienneteList= ancienneteListRepository.findById(id);
		AncienneteListDto dto=AncienneteListDto.fromEntity(ancienneteList.get());
		return Optional.of(dto).orElseThrow(()-> new EntityNotFoundException("Aucun anciennete Parametre avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.ANCIENNETE_PARAMETRE_NOT_FOUND));
	}

	@Override
	public List<AncienneteListDto> findAllByIdAnciennete(Long idAnciennete) {
		// TODO Auto-generated method stub
		if(idAnciennete==null) {
			log.error("Anciennete annee ID is null");
			return null;
		}
		Optional<Anciennete> anciennete=ancienneteRepository.findById(idAnciennete);
		if(anciennete.isEmpty()) {
			log.warn("Anciennete with ID {} was not found in the DB", idAnciennete);
			throw new EntityNotFoundException("aucun Anciennete annee avec l'ID"+idAnciennete+"n'a ete trouvez dans la BDD",ErrorCodes.ANCIENNETE_NOT_FOUND);
		}
		Optional<AncienneteList> ancienneteList=ancienneteListRepository.findByAncienneteIdannees(idAnciennete);
		if(ancienneteList.isEmpty()) {
			log.warn("Setting Anciennete Year with ID {} was not found in the BD",idAnciennete);
			throw new EntityNotFoundException("aucun Parametre avec id de annee de anciennete "+idAnciennete+"n'a ete trouvez dans la BDD",ErrorCodes.ANCIENNETE_NOT_FOUND);
		}
		return ancienneteListRepository.findAllByAnciennete(idAnciennete).stream().map(AncienneteListDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		if(id==null) {
			log.error("Anciennete setting ID is null");
			return;
		}
		ancienneteListRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdAnciennete(Long idAnciennete) {
		// TODO Auto-generated method stub
		if(idAnciennete==null) {
			log.error("Anciennete year's ID is null");
			return;
		}
		Optional<Anciennete> anciennete=ancienneteRepository.findById(idAnciennete);
		if(anciennete.isEmpty()) {
			log.warn("Anciennete year with ID {} was not found in the DB",idAnciennete);
			throw new EntityNotFoundException("aucun annee ancienneté avec l'ID"+idAnciennete+"n'a ete trouvez dans la BDD",ErrorCodes.ANCIENNETE_NOT_FOUND);
		}
		Optional<AncienneteList> ancienneteList=ancienneteListRepository.findByAncienneteIdannees(idAnciennete);
		if(ancienneteList.isEmpty()) {
			log.warn("Setting Anciennete Year with ID {} was not found in the BD",idAnciennete);
			throw new EntityNotFoundException("aucun Parametre avec id de annee d'anciennete "+idAnciennete+"n'a ete trouvez dans la BDD",ErrorCodes.ANCIENNETE_NOT_FOUND);
		}

		ancienneteListRepository.deleteAllByAnciennete(idAnciennete);
	}

	@Override
	public Collection<AncienneteListDto> findAllByAnneeAnciennete(int annee) {
		if(annee==0) {
			log.error("Anciennete annee is null");
			return null;
		}
		Optional<Anciennete> anciennete=ancienneteRepository.findAncienneteByAnnees(annee);
		if(anciennete.isEmpty()) {
			log.warn("Anciennete with year {} was not found in the DB", annee);
			throw new EntityNotFoundException("aucun Anciennete annee :"+annee+"n'a ete trouvez dans la BDD",ErrorCodes.ANCIENNETE_NOT_FOUND);
		}
		Optional<AncienneteList> ancienneteList=ancienneteListRepository.findByAncienneteAnnees(annee);
		if(ancienneteList.isEmpty()) {
			log.warn("Setting Anciennete Year with ID {} was not found in the BD",annee);
			throw new EntityNotFoundException("aucun Parametre avec annee de anciennete "+annee+"n'a ete trouvez dans la BDD",ErrorCodes.ANCIENNETE_NOT_FOUND);
		}
		return ancienneteListRepository.findAllByAncienneteAnnees(annee).stream().map(AncienneteListDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public Double findAnnéecible(Long period) {
		
		return null;
	}

	@Override
	public Double caculBrutAnc(Collection<AncienneteListDto> parametre,Long periode) {
		// TODO Auto-generated method stub
		Double tauxAn = null;
		for (AncienneteListDto  paramatre : parametre) {
			if(paramatre.getDebutTrancheAn() >= periode || paramatre.getFinTrancheAn()< periode) {
							
							tauxAn= paramatre.getTauxAnc();
							
			}
		}
		return tauxAn;
		
	

}

}
