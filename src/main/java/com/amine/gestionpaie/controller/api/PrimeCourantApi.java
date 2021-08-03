package com.amine.gestionpaie.controller.api;
import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.Collection;
import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.amine.gestionpaie.dto.PrimeCourantDto;

import io.swagger.annotations.Api;
@Api(APP_ROOT+"/prime")
public interface PrimeCourantApi {
	@PostMapping(value=APP_ROOT+"/prime/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	PrimeCourantDto save(PrimeCourantDto dto);
	@GetMapping(value=APP_ROOT+"/prime/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	PrimeCourantDto findById(Long id);
	@GetMapping(value=APP_ROOT+"/primeCourant/{type}",produces=MediaType.APPLICATION_JSON_VALUE)
	PrimeCourantDto findByType(String type);
	@GetMapping(value=APP_ROOT+"/prime/delete/{id}")
	void delete(Long id);
	@GetMapping(value=APP_ROOT+"/prime/AllBy{idEmploye}&{date}",produces=MediaType.APPLICATION_JSON_VALUE)
	Collection<PrimeCourantDto> findByPrimeEmployeAndDate(Long idEmploye, Date date);
	@GetMapping(value=APP_ROOT+"/prime/SomePrime/{prime}",produces=MediaType.APPLICATION_JSON_VALUE)
	Double calculSolePrime(Collection<PrimeCourantDto> prime);

}
