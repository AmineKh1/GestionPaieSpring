package com.amine.gestionpaie.controller.api;
import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import com.amine.gestionpaie.dto.FraisProDto;

import io.swagger.annotations.Api;
@Api(APP_ROOT+"/FraisPro")
public interface FraisProApi {
	Double calculSalaireFraisPro(FraisProDto  fraisPro,Double salaire);
	Double verifierPlafond(FraisProDto fraisPro,Double tax);
	FraisProDto findByAnnee(int annee);
	FraisProDto save(FraisProDto dto);
}
