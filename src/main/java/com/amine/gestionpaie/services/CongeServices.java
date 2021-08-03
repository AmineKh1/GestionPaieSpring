package com.amine.gestionpaie.services;

import java.util.List;

import com.amine.gestionpaie.dto.*;

public interface CongeServices {
	CongeDto save(CongeDto dto);
	CongeDto findById(Long id);
	CongeDto findByType(String type);
	List<CongeDto> findAll();
	void delete(Long id);

}
