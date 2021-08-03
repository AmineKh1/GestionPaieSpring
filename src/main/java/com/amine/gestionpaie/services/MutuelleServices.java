package com.amine.gestionpaie.services;

import java.util.List;

import com.amine.gestionpaie.dto.*;

public interface MutuelleServices {
	MutuelleDto save(MutuelleDto dto);
	MutuelleDto findById(Long id);
	MutuelleDto findByAnnee(int annee);
	List<MutuelleDto> findAll();
	void delete(Long id);

}
