package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.BanqueApi;
import com.amine.gestionpaie.dto.BanqueDto;
import com.amine.gestionpaie.services.BanqueServices;
@RestController

public class BanqueController implements BanqueApi{
	private BanqueServices banqueService;
	
	@Autowired
	public BanqueController(BanqueServices banqueService) {
		this.banqueService = banqueService;
	}

	@Override
	public BanqueDto save(BanqueDto dto) {
		// TODO Auto-generated method stub
		return banqueService.save(dto);
	}

	@Override
	public BanqueDto findById(Long id) {
		// TODO Auto-generated method stub
		return banqueService.findById(id);
	}

	@Override
	public BanqueDto findByNomBanque(String nomBanque) {
		// TODO Auto-generated method stub
		return banqueService.findByNomBanque(nomBanque);
	}

	@Override
	public List<BanqueDto> findAll() {
		// TODO Auto-generated method stub
		return banqueService.findAll();
	}

	@Override
	public void delete(Long id) {
		banqueService.delete(id);		
	}

}
