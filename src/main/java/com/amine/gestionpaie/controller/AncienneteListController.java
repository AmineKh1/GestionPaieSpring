package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.AncienneteListApi;
import com.amine.gestionpaie.dto.AncienneteListDto;
import com.amine.gestionpaie.services.AncienneteListServices;
@RestController
public class AncienneteListController implements AncienneteListApi{
	private AncienneteListServices ancienneteListServices;
	@Autowired
	public AncienneteListController(AncienneteListServices ancienneteListServices) {
		
		this.ancienneteListServices = ancienneteListServices;
	}

	@Override
	public AncienneteListDto findById(Long id) {
		// TODO Auto-generated method stub
		return ancienneteListServices.findById(id);
	}

	@Override
	public List<AncienneteListDto> findAllByIdAnciennete(Long idAnciennete) {
		// TODO Auto-generated method stub
		return ancienneteListServices.findAllByIdAnciennete(idAnciennete);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		ancienneteListServices.delete(id);
	}

	@Override
	public void deleteAllByIdAnciennete(Long idAnciennete) {
		// TODO Auto-generated method stub
		ancienneteListServices.deleteAllByIdAnciennete(idAnciennete);
	}

}
