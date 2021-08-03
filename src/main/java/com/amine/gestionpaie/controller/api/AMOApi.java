package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amine.gestionpaie.dto.AMODto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/amoParametre")
public interface AMOApi {
	@PostMapping(value = APP_ROOT +"/amoParametre/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Entregister un Amo paramètre",notes="Cette methode permet d'enregistrer ou modifier un Amo Paramètre",response= AMODto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet Amo Paramètre creer/modifie"),
			@ApiResponse(code=400, message="L'objet amo Paramètre n'est pas valide")
	})

	AMODto save(@RequestBody AMODto dto);
	
	@GetMapping(value = APP_ROOT +"/amoParamètre/{idannee}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Amo paramètre par ID",notes="Cette methode permet de chercher un Amo Paramètre par son ID",response= AMODto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Amo Paramètre a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun amo Paramètre n'existe dans la BBD avec l'ID fourni")
	})

	AMODto findById(@PathVariable("idannee") Long id);
	@GetMapping(value = APP_ROOT +"/amoParametre/{annee}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Amo paramètre par Annee",notes="Cette methode permet de chercher un Amo Paramètre par son Annee",response= AMODto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Amo Paramètre a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun amo Paramètre n'existe dans la BBD avec l'annee fourni")
	})

	AMODto findByAnnee(@PathVariable("annee") int annee);
	@GetMapping(value = APP_ROOT +"/amoParametre/all",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi la liste des paramètres d'Amo",notes="cette methode permet de chrcher et renvoyer la liste des paramètre d'amo qui existent dans la BBD",responseContainer="List<AMODto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="La liste des Amo / une Liste vide")
	})

	List<AMODto> findAll();
	@GetMapping(value = APP_ROOT +"/amoParametre/delete/{idannee}")
	@ApiOperation(value="Supprimer un Paramètre d'amo",notes="Cette methode permet de supprimer un paramètre d'amo par l'id",response= AMODto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Paramètre d'amo a ete supprimer")
	})
	
	void delete(@PathVariable("idannee") Long id);

}
