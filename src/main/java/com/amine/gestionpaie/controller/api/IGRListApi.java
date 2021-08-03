package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.amine.gestionpaie.dto.IGRListDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/igrListParametre")

public interface IGRListApi {
	@GetMapping(value = APP_ROOT +"/igrListParametre/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un parametre d'une liste d'igr par ID",notes="Cette methode permet de chercher un parametre d'une liste d'igr par son ID",response= IGRListDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " parametre d'une liste d'IGR a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun parametre d'une liste d'IGR n'existe dans la BBD avec l'ID fourni")
	})
	IGRListDto findById(Long id);
	@PostMapping(value = APP_ROOT +"/igrListParametre/all{idIGR}", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi les parametres d'une liste d'IGR",notes="cette methode permet de chrcher et renvoyer les parametres d'une liste d'IGR qui existent dans la BBD",responseContainer="List<IGRListDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="les parametres d'une liste d'IGR / une Liste vide"),
			@ApiResponse(code=404, message="Aucune liste d'IGR n'existe dans la BBD avec l'ID fourni")

	})
	List<IGRListDto> findAllByIdIGR(Long idIGR);
	@GetMapping(value = APP_ROOT +"/igrListParametre/delete/{id}")
	@ApiOperation(value="Supprimer d'un parametre d'une liste d'IGR",notes="Cette methode permet de supprimer d'un parametre d'une liste d'IGR par l'id",response= IGRListDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="le parametre d'une liste d'IGR a ete supprimer")
	})
	void delete(Long id);
	@GetMapping(value = APP_ROOT +"/igrListParametre/deleteall/all{id}")
	@ApiOperation(value="Supprimer les parametres d'une liste d'IGR",notes="Cette methode permet de supprimer les parametres d'une liste d'IGR par l'id",response= IGRListDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="les parametres d'une liste d'IGR a ete supprimer"),
			@ApiResponse(code=404, message="Aucune liste d'IGR n'existe dans la BBD avec l'ID fourni")

	})
	void deleteAllByIdIGR(Long idIGR);

}
