package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.AMOApi;
import com.amine.gestionpaie.dto.AMODto;
import com.amine.gestionpaie.services.AMOServices;
@RestController
public class AMOController implements AMOApi{
	private AMOServices amoService;
	@Autowired
	public AMOController(AMOServices amoService) {
		this.amoService = amoService;
	}

	@Override
	public AMODto save(AMODto dto) {
		// TODO Auto-generated method stub
		return amoService.save(dto);
	}

	@Override
	public AMODto findById(Long id) {
		// TODO Auto-generated method stub
		return amoService.findById(id);
	}

	@Override
	public AMODto findByAnnee(int annee) {
		// TODO Auto-generated method stub
		return amoService.findByAnnee(annee);
	}

	@Override
	public List<AMODto> findAll() {
		// TODO Auto-generated method stub
		return amoService.findAll();
	}

	@Override
	public void delete(Long id) {
		amoService.delete(id);		
	}

}
