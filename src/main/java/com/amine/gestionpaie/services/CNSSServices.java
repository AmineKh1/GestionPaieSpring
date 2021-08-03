package com.amine.gestionpaie.services;

import java.util.List;

import com.amine.gestionpaie.dto.CNSSDto;

public interface CNSSServices {
	CNSSDto save(CNSSDto dto);
	CNSSDto findById(Long id);
	CNSSDto findByAnnee(int annee);
	List<CNSSDto> findAll();
	void delete(Long id);

	Double calculSalaireCnss(CNSSDto cnss,Double salaire);

}
