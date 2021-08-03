package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amine.gestionpaie.dto.AncienneteDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/ancienneteParametre")

public interface AncienneteApi {
	@PostMapping(value = APP_ROOT +"/ancienneteParametre/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)

	@ApiOperation(value="Entregister une List anciennete paramètre",notes="Cette methode permet d'enregistrer ou modifier une liste anciennete Paramètre",response= AncienneteDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet List Anciennete Paramètre creer/modifie"),
			@ApiResponse(code=400, message="L'objet List Anciennete Paramètre n'est pas valide")
	})
	AncienneteDto save(@RequestBody AncienneteDto dto);
	@GetMapping(value = APP_ROOT +"/ancienneteParametre/{idannee}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Anciennete paramètre par ID",notes="Cette methode permet de chercher un Anciennete Paramètre par son ID",response= AncienneteDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Anciennete Paramètre a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Anciennete Paramètre n'existe dans la BBD avec l'ID fourni")
	})
	AncienneteDto findById(@PathVariable("idannee") Long id);
	@GetMapping(value = APP_ROOT +"/ancienneteParametre/{annee}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Anciennete paramètre par Annee",notes="Cette methode permet de chercher un Anciennete Paramètre par son Annee",response= AncienneteDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Anciennete Paramètre a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Anciennete Paramètre n'existe dans la BBD avec l'annee fourni")
	})
	AncienneteDto findByAnnee(int annee);
	@GetMapping(value = APP_ROOT +"/ancienneteParametre/all",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi la liste des paramètres de Anciennete",notes="cette methode permet de chrcher et renvoyer la liste des paramètre de Anciennete qui existent dans la BBD",responseContainer="List<AncienneteDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="La liste des Anciennete / une Liste vide")
	})
	List<AncienneteDto> findAll();
	@GetMapping(value = APP_ROOT +"/ancienneteParametre/delete/{idannee}")
	@ApiOperation(value="Supprimer un Paramètre de Anciennete",notes="Cette methode permet de supprimer un paramètre de Anciennete par l'id",response= AncienneteDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Paramètre de Anciennete a ete supprimer")
	})
	void delete(@PathVariable("idannee") Long id);

}
