package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.PretApi;
import com.amine.gestionpaie.dto.PretDto;
import com.amine.gestionpaie.services.PretServices;

@RestController

public class PretController implements PretApi{
	private PretServices pretService;
	
	@Autowired
	public PretController(PretServices pretService) {
		this.pretService = pretService;
	}

	@Override
	public PretDto save(PretDto dto) {
		// TODO Auto-generated method stub
		return pretService.save(dto);
	}

	@Override
	public PretDto findById(Long id) {
		// TODO Auto-generated method stub
		return pretService.findById(id);
	}

	@Override
	public List<PretDto> findAll() {
		// TODO Auto-generated method stub
		return pretService.findAll();
	}

	@Override
	public void delete(Long id) {
		pretService.delete(id);		
	}

}
