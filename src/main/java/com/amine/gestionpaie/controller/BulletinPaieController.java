package com.amine.gestionpaie.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.BulletinPaieApi;
import com.amine.gestionpaie.dto.BulletinPaieDto;
import com.amine.gestionpaie.services.BulletinPaieServices;
@RestController

public class BulletinPaieController implements BulletinPaieApi{
	private BulletinPaieServices bulletinPaieServices;
	@Autowired
	public BulletinPaieController(BulletinPaieServices bulletinPaieServices) {
	
		this.bulletinPaieServices = bulletinPaieServices;
	}

	@Override
	public BulletinPaieDto save(BulletinPaieDto dto) {
		// TODO Auto-generated method stub
		return bulletinPaieServices.save(dto);
	}

	@Override
	public BulletinPaieDto findById(Long id) {
		// TODO Auto-generated method stub
		return bulletinPaieServices.findById(id);
	}

	@Override
	public List<BulletinPaieDto> findAllByIdEmploye(Long IdEmploye) {
		// TODO Auto-generated method stub
		return bulletinPaieServices.findAllByIdEmploye(IdEmploye);
	}

	@Override
	public BulletinPaieDto findByIdEmployefindByDate(Long idEmploye, Date date) {
		// TODO Auto-generated method stub
		return bulletinPaieServices.findByIdEmployefindByDate(idEmploye, date);
	}

	@Override
	public List<BulletinPaieDto> findAll() {
		// TODO Auto-generated method stub
		return bulletinPaieServices.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		bulletinPaieServices.delete(id);
	}

	@Override
	public void deleteAllByIdEmploye(Long idEmploye) {
		// TODO Auto-generated method stub
		bulletinPaieServices.deleteAllByIdEmploye(idEmploye);
	}

}
