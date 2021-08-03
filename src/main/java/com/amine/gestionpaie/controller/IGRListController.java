package com.amine.gestionpaie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amine.gestionpaie.controller.api.IGRListApi;
import com.amine.gestionpaie.dto.IGRListDto;
import com.amine.gestionpaie.services.IGRListServices;
@RestController
public class IGRListController implements IGRListApi{
	private IGRListServices igrListServices;
	@Autowired
	public IGRListController(IGRListServices igrListServices) {
		this.igrListServices = igrListServices;
	}

	@Override
	public IGRListDto findById(Long id) {
		// TODO Auto-generated method stub
		return igrListServices.findById(id);
	}

	
	@Override
	public List<IGRListDto> findAllByIdIGR(Long idIGR) {
		// TODO Auto-generated method stub
		return igrListServices.findAllByIdIGR(idIGR);
	}

	@Override
	public void delete(Long id) {
		igrListServices.delete(id);		
	}

	@Override
	public void deleteAllByIdIGR(Long idIGR) {
		igrListServices.deleteAllByIdIGR(idIGR);		
	}

}
