package com.amine.gestionpaie.services.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.gestionpaie.dto.IGRDto;
import com.amine.gestionpaie.dto.IGRListDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.model.anneeConfig.IGR;
import com.amine.gestionpaie.model.anneeConfig.IGRList;
import com.amine.gestionpaie.repository.IGRListRepository;
import com.amine.gestionpaie.repository.IGRRepository;

import com.amine.gestionpaie.services.IGRListServices;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IGRListServiceImpl implements IGRListServices{
	private IGRListRepository igrListRepository;
	private IGRRepository igrRepository;
	
	@Autowired
	public IGRListServiceImpl(IGRListRepository igrListRepository,IGRRepository igrRepository) {
		this.igrListRepository = igrListRepository;
		this.igrRepository = igrRepository;
	}

	

	@Override
	public IGRListDto findById(Long id) {
		// TODO Auto-generated method stub
		if(id==null){
			log.error("IGR Setting ID's null");
			return null;
		}
		Optional<IGRList> igrList= igrListRepository.findById(id);
		IGRListDto dto=IGRListDto.fromEntity(igrList.get());
		
		return Optional.of(dto).orElseThrow(()-> new EntityNotFoundException("Aucun igr Parametre avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.IGR_PARAMETRE_NOT_FOUND));
	}

	@Override
	public List<IGRListDto> findAllByIdIGR(Long idIGR) {
		// TODO Auto-generated method stub
		if(idIGR==null) {
			log.error("Igr year ID's null");
			return null;
		}
		Optional<IGR> igr=igrRepository.findById(idIGR);
		if(igr.isEmpty()) {
			log.warn("Igr year with ID {} was not found in DB",idIGR);
			throw new EntityNotFoundException("aucun IGR annee avec l'ID"+idIGR+"n'a ete trouvez dans la BDD",ErrorCodes.IGR_NOT_FOUND);
			
		}
		Optional<IGRList> igrList=igrListRepository.findByIgrIdannees(idIGR);
		if(igrList.isEmpty()) {
			log.warn("Setting IGR year with ID {} was not found in the DB",idIGR);
			throw new EntityNotFoundException("aucun parametre avec id de annee de IGR"+idIGR+"n'a ete trouvez dans la BBD",ErrorCodes.IGR_NOT_FOUND);
		}
		return igrListRepository.findAllByIgr(idIGR).stream().map(IGRListDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		if(id==null) {
			log.error("IGR Setting ID is null");
			return;
		}
		igrListRepository.deleteById(id);
	}



	@Override
	public void deleteAllByIdIGR(Long idIGR) {
		// TODO Auto-generated method stub
		if(idIGR==null) {
			log.error("IGR year's ID is null");
			return;
		}
		Optional<IGR> igr=igrRepository.findById(idIGR);
		if(igr.isEmpty()) {
			log.warn("Igr year with ID {} was not found in DB",idIGR);
			throw new EntityNotFoundException("aucun IGR annee avec l'ID"+idIGR+"n'a ete trouvez dans la BDD",ErrorCodes.IGR_NOT_FOUND);
			
		}
		Optional<IGRList> igrList=igrListRepository.findByIgrIdannees(idIGR);
		if(igrList.isEmpty()) {
			log.warn("Setting IGR year with ID {} was not found in the DB",idIGR);
			throw new EntityNotFoundException("aucun parametre avec id de annee de IGR"+idIGR+"n'a ete trouvez dans la BBD",ErrorCodes.IGR_NOT_FOUND);
		}
		igrListRepository.deleteAllByIgr(idIGR);
		
	}



	@Override
	public List<IGRListDto> findAllByAnneeIGR(int annee) {
		// TODO Auto-generated method stub
		if(annee==0) {
			log.error("Igr year's null");
			return null;
		}
		Optional<IGR> igr=igrRepository.findIGRByAnnees(annee);
		if(igr.isEmpty()) {
			log.warn("Igr year  {} was not found in DB",annee);
			throw new EntityNotFoundException("aucun IGR annee :"+annee+"n'a ete trouvez dans la BDD",ErrorCodes.IGR_NOT_FOUND);
			
		}
		Optional<IGRList> igrList=igrListRepository.findByIgrAnnees(annee);
		if(igrList.isEmpty()) {
			log.warn("Setting IGR year with ID {} was not found in the DB",annee);
			throw new EntityNotFoundException("aucun parametre avec id de annee de IGR"+annee+"n'a ete trouvez dans la BBD",ErrorCodes.IGR_NOT_FOUND);
		}
		return igrListRepository.findAllByIgrAnnees(annee).stream().map(IGRListDto::fromEntity).collect(Collectors.toList());

	}



	@Override
	public IGRListDto findIgr(Collection<IGRListDto> igrList, Double sni) {
		// TODO Auto-generated method stub
		IGRListDto igr = null;
		for(IGRListDto parametre:igrList) {
			if(parametre.getDebutTrancheIGR()>=sni || parametre.getFinTrancheIGR()<sni) {
				igr=parametre;
			}
		}
		return igr;
	}

}
