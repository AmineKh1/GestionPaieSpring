package com.amine.gestionpaie.services;

import java.util.List;

import com.amine.gestionpaie.dto.*;

public interface BanqueServices {
	BanqueDto save(BanqueDto dto);
	BanqueDto findById(Long id);
	BanqueDto findByNomBanque(String nomBanque);
	List<BanqueDto> findAll();
	void delete(Long id);

}
