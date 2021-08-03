package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amine.gestionpaie.dto.AvanceDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/avance")

public interface AvanceApi {
	@PostMapping(value = APP_ROOT +"/avance/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Entregister un Avance",notes="Cette methode permet d'enregistrer ou modifier une Avance",response= AvanceDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet Avance creer/modifie"),
			@ApiResponse(code=400, message="L'objet Avance n'est pas valide")
	})
	AvanceDto save(@RequestBody AvanceDto dto);
	
	@GetMapping(value = APP_ROOT +"/avance/{idAvance}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Avance par ID",notes="Cette methode permet de chercher une Avance par son ID",response= AvanceDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Avance a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Avance n'existe dans la BBD avec l'ID fourni")
	})
	AvanceDto findById(@PathVariable("idAvance") Long id);
	
	@GetMapping(value = APP_ROOT +"/avance/all",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi la liste des Avance",notes="cette methode permet de chrcher et renvoyer la liste des Avance qui existent dans la BBD",responseContainer="List<AvanceDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="La liste des Avances / une Liste vide")
	})
	List<AvanceDto> findAll();
	
	@GetMapping(value = APP_ROOT +"/avance/delete/{idAvance}")
	@ApiOperation(value="Supprimer d'Avance",notes="Cette methode permet de supprimer de Avance par l'id",response= AvanceDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="l'Avance a ete supprimer")
	})
	void delete(@PathVariable("idAvance") Long id);
}
