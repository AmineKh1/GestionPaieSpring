package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.ContratApi;
import com.amine.gestionpaie.dto.ContratDto;
import com.amine.gestionpaie.services.ContratServices;

@RestController

public class ContratController implements ContratApi{
	private ContratServices contratService;
	@Autowired
	public ContratController(ContratServices contratService) {
		this.contratService = contratService;
	}

	@Override
	public ContratDto save(ContratDto dto) {
		// TODO Auto-generated method stub
		return contratService.save(dto);
	}

	@Override
	public ContratDto findById(Long id) {
		// TODO Auto-generated method stub
		return contratService.findById(id);
	}

	@Override
	public ContratDto findByType(String type) {
		// TODO Auto-generated method stub
		return contratService.findByType(type);
	}

	@Override
	public ContratDto findByProfession(String Profession) {
		// TODO Auto-generated method stub
		return contratService.findByProfession(Profession);
	}

	@Override
	public List<ContratDto> findAll() {
		// TODO Auto-generated method stub
		return contratService.findAll();
	}

	@Override
	public void delete(Long id) {
		contratService.delete(id);		
	}

}
