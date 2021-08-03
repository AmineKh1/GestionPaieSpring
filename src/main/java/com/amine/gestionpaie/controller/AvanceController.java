package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.AvanceApi;
import com.amine.gestionpaie.dto.AvanceDto;
import com.amine.gestionpaie.services.AvanceServices;
@RestController
public class AvanceController implements AvanceApi{
	private AvanceServices avanceService;
	@Autowired
	public AvanceController(AvanceServices avanceService) {

		this.avanceService = avanceService;
	}

	@Override
	public AvanceDto save(AvanceDto dto) {
		// TODO Auto-generated method stub
		return avanceService.save(dto);
	}

	@Override
	public AvanceDto findById(Long id) {
		// TODO Auto-generated method stub
		return avanceService.findById(id);
	}

	@Override
	public List<AvanceDto> findAll() {
		// TODO Auto-generated method stub
		return avanceService.findAll();
	}

	@Override
	public void delete(Long id) {
		avanceService.delete(id);		
	}

}
