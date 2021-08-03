package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.amine.gestionpaie.controller.api.EmployeApi;
import com.amine.gestionpaie.dto.EmployeDto;
import com.amine.gestionpaie.services.EmployeServices;
@RestController

public class EmployeController implements EmployeApi{
	private EmployeServices employeService;
	@Autowired
	public EmployeController(EmployeServices employeService) {
		this.employeService = employeService;
	}
	@Override
	public EmployeDto save(EmployeDto dto) {
		return employeService.save(dto);
	}

	@Override
	public EmployeDto findById(Long id) {
		return employeService.findById(id);
	}
	@Override
	public EmployeDto findBycin(String cin) {
		return employeService.findBycin(cin);
	}

	@Override
	public List<EmployeDto> findAll() {
		return employeService.findAll();
	}

	@Override
	public void delete(Long id) {
		employeService.delete(id);		
	}
	@Override
	public List<EmployeDto> findAllByIdSociete(Long idSociete) {
		// TODO Auto-generated method stub
		return employeService.findAllByIdSociete(idSociete);
	}
	@Override
	public List<EmployeDto> findAllByIdBanque(Long idBanque) {
		// TODO Auto-generated method stub
		return employeService.findAllByIdBanque(idBanque);
	}
	@Override
	public List<EmployeDto> findAllByIdDepartement(Long idDepartement) {
		// TODO Auto-generated method stub
		return employeService.findAllByIdDepartement(idDepartement);
	}

}
