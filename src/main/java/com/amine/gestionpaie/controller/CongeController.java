package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.CongeApi;
import com.amine.gestionpaie.dto.CongeDto;
import com.amine.gestionpaie.services.CongeServices;
@RestController
public class CongeController implements CongeApi{
	private CongeServices congeService;
	@Autowired
	public CongeController(CongeServices congeService) {

		this.congeService = congeService;
	}

	@Override
	public CongeDto save(CongeDto dto) {
		// TODO Auto-generated method stub
		return congeService.save(dto);
	}

	@Override
	public CongeDto findById(Long id) {
		// TODO Auto-generated method stub
		return congeService.findById(id);
	}

	@Override
	public CongeDto findByType(String type) {
		// TODO Auto-generated method stub
		return congeService.findByType(type);
	}

	@Override
	public List<CongeDto> findAll() {
		// TODO Auto-generated method stub
		return congeService.findAll();
	}

	@Override
	public void delete(Long id) {
		congeService.delete(id);		
	}

}
