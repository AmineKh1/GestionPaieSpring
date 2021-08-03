package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amine.gestionpaie.dto.PretDto;
import com.amine.gestionpaie.services.PretServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/pret")

public interface PretApi {
	@PostMapping(value = APP_ROOT +"/pret/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Entregister un Pret",notes="Cette methode permet d'enregistrer ou modifier un Pret",response= PretDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet Pret creer/modifie"),
			@ApiResponse(code=400, message="L'objet Pret n'est pas valide")
	})
	PretDto save(@RequestBody PretDto dto);
	
	@PostMapping(value = APP_ROOT +"/pret/{idPret}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Pret par ID",notes="Cette methode permet de chercher un Pret par son ID",response= PretDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Pret a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Pret n'existe dans la BBD avec l'ID fourni")
	})
	PretDto findById(@PathVariable("idPret") Long id);
	@GetMapping(value = APP_ROOT +"/pret/all",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi la liste des Pret",notes="cette methode permet de chrcher et renvoyer la liste des Pret qui existent dans la BBD",responseContainer="List<PretDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="La liste des Prets / une Liste vide")
	})
	List<PretDto> findAll();
	@GetMapping(value = APP_ROOT +"/pret/delete/{idPret}")
	@ApiOperation(value="Supprimer de Pret",notes="Cette methode permet de supprimer de Pret par l'id",response= PretDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="la Pret a ete supprimer")
	})
	
	void delete(@PathVariable("idPret") Long id);
}
