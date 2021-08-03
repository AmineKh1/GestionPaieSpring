package com.amine.gestionpaie.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.gestionpaie.dto.FraisProDto;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.model.anneeConfig.FraisPro;
import com.amine.gestionpaie.repository.FraisProRepository;
import com.amine.gestionpaie.services.FraisProServices;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class FraisProServiceImpl implements FraisProServices{
	private FraisProRepository fraisProRepository;
	
	@Autowired
	public FraisProServiceImpl(FraisProRepository fraisProRepository) {

		this.fraisProRepository = fraisProRepository;
	}

	@Override
	public Double calculSalaireFraisPro(FraisProDto fraisPro, Double salaire) {
		// TODO Auto-generated method stub
		Double sl;
		
		sl=salaire*fraisPro.getTauxFrais();
		return sl;
	}
	
	@Override
	public FraisProDto findByAnnee(int annee) {
		// TODO Auto-generated method stub
		if(annee==0) {
			log.error("frais Pro annee is null");
			return null;
		}
		Optional<FraisPro> fraisPro=fraisProRepository.findByAnnees(annee);
		FraisProDto dto=FraisProDto.fromEntity(fraisPro.get());
		return Optional.of(dto).orElseThrow(()->new EntityNotFoundException("Aucn frais pro avec l'annee ="+annee+"n'a ete trouve dans la base de données",ErrorCodes.FRAISPRO_NOT_FOUND));

	}

	@Override
	public Double verifierPlafond(FraisProDto fraisPro, Double tax) {
		// TODO Auto-generated method stub
		if(tax<=fraisPro.getPlafond()) {
			return tax;
		}
		else {
		return fraisPro.getPlafond();
		}
	}

	@Override
	public FraisProDto save(FraisProDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
