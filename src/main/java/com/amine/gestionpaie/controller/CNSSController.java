package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.CNSSApi;
import com.amine.gestionpaie.dto.CNSSDto;
import com.amine.gestionpaie.services.CNSSServices;
import com.amine.gestionpaie.services.MutuelleServices;

@RestController
public class CNSSController implements CNSSApi{
	private CNSSServices cnssService;
	
	@Autowired
	public CNSSController(CNSSServices cnssService) {
		this.cnssService = cnssService;
	}

	@Override
	public CNSSDto save(CNSSDto dto) {
		// TODO Auto-generated method stub
		return cnssService.save(dto);
	}

	@Override
	public CNSSDto findById(Long id) {
		// TODO Auto-generated method stub
		return cnssService.findById(id);
	}

	@Override
	public CNSSDto findByAnnee(int annee) {
		// TODO Auto-generated method stub
		return cnssService.findByAnnee(annee);
	}

	@Override
	public List<CNSSDto> findAll() {
		// TODO Auto-generated method stub
		return cnssService.findAll();
	}

	@Override
	public void delete(Long id) {
		cnssService.delete(id);		
	}
	

}
