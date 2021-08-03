package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.amine.gestionpaie.controller.api.MutuelleApi;
import com.amine.gestionpaie.dto.MutuelleDto;
import com.amine.gestionpaie.services.MutuelleServices;

public class MutuelleController  implements MutuelleApi{
private MutuelleServices mutuelleService;
	@Autowired
	public MutuelleController(MutuelleServices mutuelleService) {
	
		this.mutuelleService = mutuelleService;
	}

@Override
public MutuelleDto save(MutuelleDto dto) {
	// TODO Auto-generated method stub
	return mutuelleService.save(dto);
}


@Override
public MutuelleDto findById(Long id) {
	// TODO Auto-generated method stub
	return mutuelleService.findById(id);
}

@Override
public MutuelleDto findByAnnee(int annee) {
	// TODO Auto-generated method stub
	return mutuelleService.findByAnnee(annee);
}

@Override
public List<MutuelleDto> findAll() {
	// TODO Auto-generated method stub
	return mutuelleService.findAll();
}

@Override
public void delete(Long id) {
	mutuelleService.delete(id);	
}
	


}
