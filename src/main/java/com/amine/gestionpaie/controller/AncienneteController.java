package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.AncienneteApi;
import com.amine.gestionpaie.dto.AncienneteDto;
import com.amine.gestionpaie.services.AncieneteServices;

@RestController

public class AncienneteController implements AncienneteApi{
	private AncieneteServices ancienneteService;
	
	@Autowired
	public AncienneteController(AncieneteServices ancienneteService) {
		this.ancienneteService = ancienneteService;
	}

	@Override
	public AncienneteDto save(AncienneteDto dto) {
		// TODO Auto-generated method stub
		return ancienneteService.save(dto);
	}

	@Override
	public AncienneteDto findById(Long id) {
		// TODO Auto-generated method stub
		return ancienneteService.findById(id);
	}

	@Override
	public AncienneteDto findByAnnee(int annee) {
		// TODO Auto-generated method stub
		return ancienneteService.findByAnnee(annee);
	}

	@Override
	public List<AncienneteDto> findAll() {
		// TODO Auto-generated method stub
		return ancienneteService.findAll();
	}

	@Override
	public void delete(Long id) {
		ancienneteService.delete(id);		
	}

}
