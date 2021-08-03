package com.amine.gestionpaie.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.gestionpaie.dto.IGRDto;
import com.amine.gestionpaie.dto.IGRListDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.anneeConfig.IGR;
import com.amine.gestionpaie.model.anneeConfig.IGRList;
import com.amine.gestionpaie.repository.IGRListRepository;
import com.amine.gestionpaie.repository.IGRRepository;
import com.amine.gestionpaie.services.IGRServices;
import com.amine.gestionpaie.validators.IGRListValidator;
import com.amine.gestionpaie.validators.IGRValidator;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class IGRServiceImpl implements IGRServices{
	private IGRRepository igrRepository;
	private IGRListRepository igrListRepository;
	@Autowired
	public IGRServiceImpl(IGRRepository igrRepository,IGRListRepository igrListRepository) {
		
		this.igrRepository = igrRepository;
		this.igrListRepository=igrListRepository;
	}

	@Override
	public IGRDto save(IGRDto dto) {
		// TODO Auto-generated method stub
		List<String> errors=IGRValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("annee IGR is not valid", dto);
			throw new InvalidEntityException("annee igr n'est pas valide",ErrorCodes.IGR_NOT_VALID,errors);
			
		}
		List<String> errorsList= IGRListValidator.validate(dto.getIgrList());
		if(!errorsList.isEmpty()) {
			log.error("igr parametre est vide");;
			throw new InvalidEntityException("parametre n'est pas valide",ErrorCodes.IGR_PARAMETRE_NOT_VALID);
			
		}
		IGR savedIGR= igrRepository.save(IGRDto.toEntity(dto));
		dto.getIgrList().forEach(igr->{
			IGRList igrList = IGRListDto.toEntity(igr);
			igrList.setIgr(savedIGR);
			igrListRepository.save(igrList);
		});
		return IGRDto.fromEntity(savedIGR);
	}

	

	@Override
	public IGRDto findById(Long id) {
		if(id==null) {
			log.error("annee igr ID is null");
			return null;
		}
		Optional<IGR> igr=igrRepository.findById(id);
		IGRDto dto = IGRDto.fromEntity(igr.get());
		return Optional.of(dto).orElseThrow(()-> new EntityNotFoundException("aucun igr annee avec l'id ="+id+"n'a ete trouve dans la BDD",ErrorCodes.IGR_NOT_FOUND));
	}

	@Override
	public IGRDto findByAnnee(int annee) {
		if(annee==0) {
			log.error("annee Anciennete is null");
			return null;
		}
		Optional<IGR> igr=igrRepository.findIGRByAnnees(annee);
		IGRDto dto= IGRDto.fromEntity(igr.get());
		return Optional.of(dto).orElseThrow(()-> new EntityNotFoundException("aucun igr annee avec le nom ="+annee+ "n'a ete trouve dans la BDD",ErrorCodes.IGR_NOT_FOUND));
		
	}

	@Override
	public List<IGRDto> findAll() {
		// TODO Auto-generated method stub
		return igrRepository.findAll().stream().map(IGRDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		if(id==null) {
			log.error("IGR annee ID is null");
			return;
			
		}
		igrRepository.deleteById(id);
	}

	@Override
	public Double calculIrBrut(IGRListDto igr,Double sni) {
		// TODO Auto-generated method stub
		Double irBrut;
		irBrut=sni*igr.getTauxIGR();
		irBrut=irBrut-igr.getValeurIGR();
		return irBrut;
	}

}
