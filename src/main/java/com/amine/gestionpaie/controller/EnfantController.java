package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.EnfantApi;
import com.amine.gestionpaie.dto.EnfantDto;
import com.amine.gestionpaie.services.EnfantServices;

@RestController
public class EnfantController implements EnfantApi{
	private EnfantServices enfantService;
	@Autowired
	public EnfantController(EnfantServices enfantService) {
		this.enfantService = enfantService;
	}

	@Override
	public EnfantDto save(EnfantDto dto) {
		// TODO Auto-generated method stub
		return enfantService.save(dto);
	}

	@Override
	public EnfantDto findById(Long id) {
		// TODO Auto-generated method stub
		return enfantService.findById(id);
	}

	@Override
	public List<EnfantDto> findAll() {
		// TODO Auto-generated method stub
		return enfantService.findAll();
	}

	@Override
	public void delete(Long id) {
		enfantService.delete(id);		
	}

}
