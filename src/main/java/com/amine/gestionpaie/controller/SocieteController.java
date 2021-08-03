package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.SocieteApi;
import com.amine.gestionpaie.dto.SocieteDto;
import com.amine.gestionpaie.services.SocieteServices;
@RestController
public class SocieteController implements SocieteApi{
	
	private SocieteServices societeService;
	@Autowired
	public SocieteController(SocieteServices societeService) {
		this.societeService = societeService;
	}
	@Override
	public SocieteDto save(SocieteDto dto) {
		return societeService.save(dto);
	}
	@Override
	public SocieteDto findById(Long id) {
		return societeService.findById(id);
	}
	@Override
	public SocieteDto findByNomSociete(String nomSociete) {
		return societeService.findByNomSociete(nomSociete);
	}

	@Override
	public List<SocieteDto> findAll() {
		return societeService.findAll();
	}

	@Override
	public void delete(Long id) {
		societeService.delete(id);
		
	}

}
