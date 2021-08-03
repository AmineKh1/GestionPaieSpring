package com.amine.gestionpaie.services;

import java.util.List;

import com.amine.gestionpaie.dto.*;

public interface IGRServices {
	IGRDto save(IGRDto dto);
	IGRDto findById(Long id);
	IGRDto findByAnnee(int annee);
	List<IGRDto> findAll();
	void delete(Long id);
	Double calculIrBrut(IGRListDto igr,Double sni);	

}
