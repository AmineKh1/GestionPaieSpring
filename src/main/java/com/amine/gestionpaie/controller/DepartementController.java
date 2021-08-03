package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.DepartementApi;
import com.amine.gestionpaie.dto.DepartementDto;
import com.amine.gestionpaie.services.DepartementServices;

@RestController
public class DepartementController implements DepartementApi{
	private DepartementServices departementServices;
	@Override
	public DepartementDto save(DepartementDto dto) {
		// TODO Auto-generated method stub
		return departementServices.save(dto);
	}

	@Override
	public DepartementDto findById(Long id) {
		// TODO Auto-generated method stub
		return departementServices.findById(id);
	}

	@Override
	public List<DepartementDto> findAll() {
		// TODO Auto-generated method stub
		return departementServices.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		departementServices.delete(id);
	}

	@Override
	public List<DepartementDto> findAllByIdSociete(Long idSociete) {
		// TODO Auto-generated method stub
		return departementServices.findAllByIdSociete(idSociete);
	}

}
