package com.amine.gestionpaie.services;

import com.amine.gestionpaie.dto.FraisProDto;

public interface FraisProServices {
	Double calculSalaireFraisPro(FraisProDto  fraisPro,Double salaire);
	Double verifierPlafond(FraisProDto fraisPro,Double tax);
	FraisProDto findByAnnee(int annee);
	FraisProDto save(FraisProDto dto);
}
