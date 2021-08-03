package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.CreditApi;
import com.amine.gestionpaie.dto.CreditDto;
import com.amine.gestionpaie.services.CreditServices;
@RestController
public class CreditController implements CreditApi{
	private CreditServices creditService;
	
	@Autowired
	public CreditController(CreditServices creditService) {

		this.creditService = creditService;
	}

	@Override
	public CreditDto save(CreditDto dto) {
		// TODO Auto-generated method stub
		return creditService.save(dto);
	}

	@Override
	public CreditDto findById(Long id) {
		// TODO Auto-generated method stub
		return creditService.findById(id);
	}

	@Override
	public List<CreditDto> findAll() {
		// TODO Auto-generated method stub
		return creditService.findAll();
	}

	@Override
	public void delete(Long id) {
		creditService.delete(id);		
	}



}
