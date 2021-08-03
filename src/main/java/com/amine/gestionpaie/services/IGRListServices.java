package com.amine.gestionpaie.services;

import java.util.Collection;
import java.util.List;

import com.amine.gestionpaie.dto.*;

public interface IGRListServices {

	IGRListDto findById(Long id);
	
	List<IGRListDto> findAllByIdIGR(Long idIGR);
	void delete(Long id);
	void deleteAllByIdIGR(Long idIGR);
	List<IGRListDto> findAllByAnneeIGR(int annee);
	IGRListDto findIgr(Collection<IGRListDto> igrList,Double sni);
	

}
