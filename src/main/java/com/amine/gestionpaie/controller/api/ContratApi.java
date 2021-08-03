package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amine.gestionpaie.dto.ContratDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/contrat")

public interface ContratApi {
	@PostMapping(value = APP_ROOT +"/contrat/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Entregister un Contrat",notes="Cette methode permet d'enregistrer ou modifier une Contrat",response= ContratDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet Contrat creer/modifie"),
			@ApiResponse(code=400, message="L'objet Contrat n'est pas valide")
	})
	ContratDto save(@RequestBody ContratDto dto);
	@GetMapping(value = APP_ROOT +"/contrat/{idContrat}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Contrat par ID",notes="Cette methode permet de chercher une Contrat par son ID",response= ContratDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Contrat a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Contrat n'existe dans la BBD avec l'ID fourni")
	})
	ContratDto findById(@PathVariable("idContrat") Long id);
	@GetMapping(value = APP_ROOT +"/contrat/{typeContrat}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Contrat par type de Contrat",notes="Cette methode permet de chercher un Contrat par son type",response= ContratDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Contrat a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Contrat n'existe dans la BBD avec le type de Contrat fourni")
	})
	ContratDto findByType(@PathVariable("typeContrat") String type);
	@GetMapping(value = APP_ROOT +"/contrat/{professionContrat}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Contrat par Profession de Contrat",notes="Cette methode permet de chercher un Contrat par sa profession noté",response= ContratDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Contrat a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Contrat n'existe dans la BBD avec le nom de Contrat fourni")
	})
	ContratDto findByProfession(@PathVariable("professionContrat") String Profession);
	@GetMapping(value = APP_ROOT +"/contrat/all",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi la liste des Contrat",notes="cette methode permet de chrcher et renvoyer la liste des Contrat qui existent dans la BBD",responseContainer="List<ContratDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="La liste des Contrats / une Liste vide")
	})
	List<ContratDto> findAll();
	@GetMapping(value = APP_ROOT +"/contrat/delete/{idContrat}")
	@ApiOperation(value="Supprimer de Contrat",notes="Cette methode permet de supprimer de Contrat par l'id",response= ContratDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="la Contrat a ete supprimer")
	})
	
	void delete(@PathVariable("idContrat") Long id);

}
