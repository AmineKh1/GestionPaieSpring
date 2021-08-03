package com.amine.gestionpaie.controller.api;
import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.Collection;
import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import com.amine.gestionpaie.dto.PrimeNoExoDto;

import io.swagger.annotations.Api;

@Api(APP_ROOT+"/Prime")
public interface PrimeNoExoApi {
	@GetMapping(value=APP_ROOT+"/prime/SomePrime/{prime}",produces=MediaType.APPLICATION_JSON_VALUE)
	Double calculSolePrime(Collection<PrimeNoExoDto> prime);
	@GetMapping(value=APP_ROOT+"/primeCourant/{nom}",produces=MediaType.APPLICATION_JSON_VALUE)
	PrimeNoExoDto findByNom(String nom);
	@GetMapping(value=APP_ROOT+"/prime/AllBy{idEmploye}&{date}",produces=MediaType.APPLICATION_JSON_VALUE)
	Collection<PrimeNoExoDto> findByPrimeEmployeAndDate(Long idEmploye, Date date);

}
