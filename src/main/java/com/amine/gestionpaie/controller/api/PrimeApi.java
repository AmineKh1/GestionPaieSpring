package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.Collection;
import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amine.gestionpaie.dto.PrimeNormalDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/prime")

public interface PrimeApi {
	
	@PostMapping(value = APP_ROOT +"/prime/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Entregister un Prime",notes="Cette methode permet d'enregistrer ou modifier un Prime",response= PrimeNormalDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet Prime creer/modifie"),
			@ApiResponse(code=400, message="L'objet Prime n'est pas valide")
	})
	PrimeNormalDto save(@RequestBody PrimeNormalDto dto);
	
	@PostMapping(value = APP_ROOT +"/prime/{idPrime}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Prime par ID",notes="Cette methode permet de chercher un Prime par son ID",response= PrimeNormalDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Prime a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Prime n'existe dans la BBD avec l'ID fourni")
	})
	PrimeNormalDto findById(@PathVariable("idPrime") Long id);
	
	@GetMapping(value = APP_ROOT +"/prime/{nomPrime}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Prime par nom de Prime",notes="Cette methode permet de chercher un Prime par son nom",response= PrimeNormalDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Prime a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Prime n'existe dans la BBD avec le nom de Prime fourni")
	})
	PrimeNormalDto findByNom(@PathVariable("nomPrime")String type);
	
	@GetMapping(value = APP_ROOT +"/prime/delete/{idPrime}")
	@ApiOperation(value="Supprimer de Prime",notes="Cette methode permet de supprimer de Prime par l'id",response= PrimeNormalDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="la Prime a ete supprimer")
	})
	void delete(@PathVariable("idPrime") Long id);
	 
	@GetMapping(value=APP_ROOT+"/prime/AllBy{idEmploye}&{date}",produces=MediaType.APPLICATION_JSON_VALUE)
	Collection<PrimeNormalDto> findByPrimeEmployeAndDate(Long idEmploye,Date date);
	
	@GetMapping(value=APP_ROOT+"/prime/SomePrime/{prime}",produces=MediaType.APPLICATION_JSON_VALUE)
	Double calculSolePrime(Collection<PrimeNormalDto> prime);
}
