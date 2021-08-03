package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.amine.gestionpaie.dto.AncienneteListDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/ancienneteListParametre")

public interface AncienneteListApi {
	@GetMapping(value = APP_ROOT +"/AncienneteListParametre/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un parametre d'une liste d'anciennete par ID",notes="Cette methode permet de chercher un parametre d'une liste d'anciennete par son ID",response= AncienneteListDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " parametre d'une liste d'anciennete a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun parametre d'une liste d'anciennete n'existe dans la BBD avec l'ID fourni")
	})
	AncienneteListDto findById(Long id);
	@PostMapping(value = APP_ROOT +"/AncienneteListParametre/all{idAnciennete}", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi les parametres d'une liste d'anciennete",notes="cette methode permet de chrcher et renvoyer les parametres d'une liste d'anciennete qui existent dans la BBD",responseContainer="List<AncienneteListDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="les parametres d'une liste d'anciennete / une Liste vide"),
			@ApiResponse(code=404, message="Aucune liste d'anciennete n'existe dans la BBD avec l'ID fourni")

	})
	List<AncienneteListDto> findAllByIdAnciennete(Long idAnciennete);
	@GetMapping(value = APP_ROOT +"/AncienneteParametre/delete/{id}")
	@ApiOperation(value="Supprimer d'un parametre d'une liste d'anciennete",notes="Cette methode permet de supprimer d'un parametre d'une liste d'anciennete par l'id",response= AncienneteListDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="le parametre d'une liste d'anciennete a ete supprimer")
	})
	void delete(Long id);
	@GetMapping(value = APP_ROOT +"/AncienneteListParametre/deleteall/all{id}")
	@ApiOperation(value="Supprimer les parametres d'une liste d'anciennete",notes="Cette methode permet de supprimer les parametres d'une liste d'anciennete par l'id",response= AncienneteListDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="les parametres d'une liste d'anciennete a ete supprimer"),
			@ApiResponse(code=404, message="Aucune liste d'anciennete n'existe dans la BBD avec l'ID fourni")

	})
	void deleteAllByIdAnciennete(Long idAnciennete);

}
