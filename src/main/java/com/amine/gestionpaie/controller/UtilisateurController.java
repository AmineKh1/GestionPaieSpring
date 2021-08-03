package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.EmployeApi;
import com.amine.gestionpaie.controller.api.UtilisateurApi;
import com.amine.gestionpaie.dto.EmployeDto;
import com.amine.gestionpaie.dto.UtilisateurDto;
import com.amine.gestionpaie.services.UtilisateurServices;
@RestController

public class UtilisateurController implements UtilisateurApi{
	private UtilisateurServices utilisateurservice;
	
	@Autowired
	public UtilisateurController(UtilisateurServices utilisateurservice) {
		this.utilisateurservice = utilisateurservice;
	}



	@Override
	public UtilisateurDto save(UtilisateurDto dto) {
		// TODO Auto-generated method stub
		return utilisateurservice.save(dto);
	}

	@Override
	public UtilisateurDto findById(Long id) {
		// TODO Auto-generated method stub
		return utilisateurservice.findById(id);
	}

	@Override
	public UtilisateurDto findByEmail(String email) {
		// TODO Auto-generated method stub
		return utilisateurservice.findByEmail(email);
	}



	@Override
	public List<UtilisateurDto> findAll() {
		// TODO Auto-generated method stub
		return utilisateurservice.findAll();
	}



	@Override
	public void delete(Long id) {
		utilisateurservice.delete(id);		
	}
	

}
