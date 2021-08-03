package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.IGRApi;
import com.amine.gestionpaie.dto.IGRDto;
import com.amine.gestionpaie.services.IGRServices;

@RestController

public class IGRController implements IGRApi{
	private IGRServices igrService;
	
	@Autowired
	public IGRController(IGRServices igrService) {
		this.igrService = igrService;
	}

	@Override
	public IGRDto save(IGRDto dto) {
		// TODO Auto-generated method stub
		return igrService.save(dto);
	}

	@Override
	public IGRDto findById(Long id) {
		// TODO Auto-generated method stub
		return igrService.findById(id);
	}

	@Override
	public IGRDto findByAnnee(int annee) {
		// TODO Auto-generated method stub
		return igrService.findByAnnee(annee);
	}

	@Override
	public List<IGRDto> findAll() {
		// TODO Auto-generated method stub
		return igrService.findAll();
	}

	@Override
	public void delete(Long id) {
		igrService.delete(id);		
	}

}
