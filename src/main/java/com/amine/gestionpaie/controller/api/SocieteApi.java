package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import com.amine.gestionpaie.dto.SocieteDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/societe")

public interface SocieteApi {
	
	@PostMapping(value = APP_ROOT +"/societe/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Entregister un Societe",notes="Cette methode permet d'enregistrer ou modifier une Societe",response= SocieteDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet Societe creer/modifie"),
			@ApiResponse(code=400, message="L'objet Societe n'est pas valide")
	})
	
	SocieteDto save(@RequestBody SocieteDto dto);
	
	@GetMapping(value = APP_ROOT +"/societe/{idSociete}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Societe par ID",notes="Cette methode permet de chercher une Societe par son ID",response= SocieteDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Societe a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Societe n'existe dans la BBD avec l'ID fourni")
	})
	
	SocieteDto findById(@PathVariable("idSociete") Long id);
	
	@GetMapping(value = APP_ROOT +"/societe/{nomSociete}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Societe par nom de societe",notes="Cette methode permet de chercher un Societe par son nom",response= SocieteDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Societe a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Societe n'existe dans la BBD avec le nom de societe fourni")
	})
	
	SocieteDto findByNomSociete(@PathVariable("nomSociete") String nomSociete);
	
	@GetMapping(value = APP_ROOT +"/societe/all",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi la liste des Societe",notes="cette methode permet de chrcher et renvoyer la liste des Societe qui existent dans la BBD",responseContainer="List<SocieteDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="La liste des Societes / une Liste vide")
	})
	List<SocieteDto> findAll();
	
	@GetMapping(value = APP_ROOT +"/societe/delete/{idSociete}")
	@ApiOperation(value="Supprimer de Societe",notes="Cette methode permet de supprimer de Societe par l'id",response= SocieteDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="la Societe a ete supprimer")
	})
	
	void delete(@PathVariable("idSociete") Long id);


}
