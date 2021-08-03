package com.amine.gestionpaie.services;

import java.util.List;

import com.amine.gestionpaie.dto.*;

public interface UtilisateurServices {
	UtilisateurDto save(UtilisateurDto dto);
	UtilisateurDto findById(Long id);
	UtilisateurDto findByEmail(String email);
	List<UtilisateurDto> findAll();

	void delete(Long id);

}
