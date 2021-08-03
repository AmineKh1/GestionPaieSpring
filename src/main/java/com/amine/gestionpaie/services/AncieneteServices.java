package com.amine.gestionpaie.services;

import java.util.List;

import com.amine.gestionpaie.dto.*;

public interface AncieneteServices {
	AncienneteDto save(AncienneteDto dto);
	AncienneteDto findById(Long id);
	AncienneteDto findByAnnee(int annee);
	List<AncienneteDto> findAll();
	void delete(Long id);
	

}
