package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amine.gestionpaie.dto.EnfantDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/enfant")

public interface EnfantApi {
	@PostMapping(value = APP_ROOT +"/enfant/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Entregister un Enfant",notes="Cette methode permet d'enregistrer ou modifier un Enfant",response= EnfantDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet Enfant creer/modifie"),
			@ApiResponse(code=400, message="L'objet Enfant n'est pas valide")
	})
	EnfantDto save(@RequestBody EnfantDto dto);
	@GetMapping(value = APP_ROOT +"/enfant/{idEnfant}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Enfant par ID",notes="Cette methode permet de chercher un Enfant par son ID",response= EnfantDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Enfant a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Enfant n'existe dans la BBD avec l'ID fourni")
	})
	EnfantDto findById(@PathVariable("idEnfant")Long id);
	@GetMapping(value = APP_ROOT +"/enfant/all",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi la liste des Enfant",notes="cette methode permet de chrcher et renvoyer la liste des Enfant qui existent dans la BBD",responseContainer="List<EnfantDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="La liste des Enfants / une Liste vide")
	})
	List<EnfantDto> findAll();
	@GetMapping(value = APP_ROOT +"/enfant/delete/{idEnfant}")
	@ApiOperation(value="Supprimer de Enfant",notes="Cette methode permet de supprimer de Enfant par l'id",response= EnfantDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="la Enfant a ete supprimer")
	})
	void delete(@PathVariable("idEnfant") Long id);

}
