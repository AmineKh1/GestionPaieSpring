package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amine.gestionpaie.dto.CNSSDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/cnssParametre")

public interface CNSSApi {
	@PostMapping(value = APP_ROOT +"/cnss/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)

	@ApiOperation(value="Entregister un CNSS paramètre",notes="Cette methode permet d'enregistrer ou modifier un CNSS Paramètre",response= CNSSDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet CNSS Paramètre creer/modifie"),
			@ApiResponse(code=400, message="L'objet CNSS Paramètre n'est pas valide")
	})
	CNSSDto save(@RequestBody CNSSDto dto);
	@GetMapping(value = APP_ROOT +"/cnss/{idannee}",produces=MediaType.APPLICATION_JSON_VALUE)

	@ApiOperation(value="Rechercher un CNSS paramètre par ID",notes="Cette methode permet de chercher un CNSS Paramètre par son ID",response= CNSSDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " CNSS Paramètre a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun CNSS Paramètre n'existe dans la BBD avec l'ID fourni")
	})
	CNSSDto findById(@PathVariable("idannee") Long id);
	@GetMapping(value = APP_ROOT +"/cnss/{annee}",produces=MediaType.APPLICATION_JSON_VALUE)

	@ApiOperation(value="Rechercher un CNSS paramètre par Annee",notes="Cette methode permet de chercher un CNSS Paramètre par son Annee",response= CNSSDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " CNSS Paramètre a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun CNSS Paramètre n'existe dans la BBD avec l'annee fourni")
	})
	CNSSDto findByAnnee(@PathVariable("annee") int annee);
	@GetMapping(value = APP_ROOT +"/cnss/all",produces=MediaType.APPLICATION_JSON_VALUE)

	@ApiOperation(value="Renvoi la liste des paramètres de CNSS",notes="cette methode permet de chrcher et renvoyer la liste des paramètre de CNSS qui existent dans la BBD",responseContainer="List<CNSSDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="La liste des CNSS / une Liste vide")
	})
	List<CNSSDto> findAll();
	@GetMapping(value = APP_ROOT +"/cnss/delete/{idannee}")
	@ApiOperation(value="Supprimer un Paramètre de CNSS",notes="Cette methode permet de supprimer un paramètre de CNSS par l'id",response= CNSSDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Paramètre de CNSS a ete supprimer")
	})

	void delete(@PathVariable("idannee") Long id);
}
