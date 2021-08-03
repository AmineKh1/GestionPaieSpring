package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amine.gestionpaie.dto.MutuelleDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/mutuelleParametre")

public interface MutuelleApi {
	@PostMapping(value = APP_ROOT +"/mutuelleParametre/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Entregister un Mutuelle paramètre",notes="Cette methode permet d'enregistrer ou modifier un Mutuelle Paramètre",response= MutuelleDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet Mutuelle Paramètre creer/modifie"),
			@ApiResponse(code=400, message="L'objet Mutuelle Paramètre n'est pas valide")
	})
	MutuelleDto save(@RequestBody MutuelleDto dto);
	@GetMapping(value = APP_ROOT +"/mutuelleParametre/{idannee}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Mutuelle paramètre par ID",notes="Cette methode permet de chercher un Mutuelle Paramètre par son ID",response= MutuelleDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Mutuelle Paramètre a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Auchun Mutuelle Paramètre n'existe dans la BBD avec l'ID fourni")
	})
	MutuelleDto findById(@PathVariable("idannee") Long id);
	@GetMapping(value = APP_ROOT +"/mutuelleParametre/{annee}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Mutuelle paramètre par Annee",notes="Cette methode permet de chercher un Mutuelle Paramètre par son Annee",response= MutuelleDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Mutuelle Paramètre a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Mutuelle Paramètre n'existe dans la BBD avec l'annee fourni")
	})
	MutuelleDto findByAnnee(@PathVariable("annee") int annee);
	@GetMapping(value = APP_ROOT +"/mutuelleParametre/all",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi la liste des paramètres de Mutuelle",notes="cette methode permet de chrcher et renvoyer la liste des paramètre de Mutuelle qui existent dans la BBD",responseContainer="List<MutuelleDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="La liste des Mutuelle / une Liste vide")
	})
	List<MutuelleDto> findAll();
	@GetMapping(value = APP_ROOT +"/mutuelleParametre/delete/{idannee}")
	@ApiOperation(value="Supprimer un Paramètre de Mutuelle",notes="Cette methode permet de supprimer un paramètre de Mutuelle par l'id",response= MutuelleDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Paramètre de Mutuelle a ete supprimer")
	})
	
	void delete(@PathVariable("idannee") Long id);

}
