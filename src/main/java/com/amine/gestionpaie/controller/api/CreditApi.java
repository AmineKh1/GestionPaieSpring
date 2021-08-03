package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amine.gestionpaie.dto.CreditDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/credit")

public interface CreditApi {
	@PostMapping(value = APP_ROOT +"/credit/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Entregister un Credit",notes="Cette methode permet d'enregistrer ou modifier un Credit",response= CreditDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet Credit creer/modifie"),
			@ApiResponse(code=400, message="L'objet Credit n'est pas valide")
	})
	CreditDto save(@RequestBody CreditDto dto);
	@GetMapping(value = APP_ROOT +"/credit/{idCredit}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Credit par ID",notes="Cette methode permet de chercher un Credit par son ID",response= CreditDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Credit a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Credit n'existe dans la BBD avec l'ID fourni")
	})
	CreditDto findById(@PathVariable("idCredit") Long id);
	@GetMapping(value = APP_ROOT +"/credit/all",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi la liste des Credit",notes="cette methode permet de chrcher et renvoyer la liste des Credit qui existent dans la BBD",responseContainer="List<CreditDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="La liste des Credits / une Liste vide")
	})
	List<CreditDto> findAll();
	@GetMapping(value = APP_ROOT +"/credit/delete/{idCredit}")
	@ApiOperation(value="Supprimer de Credit",notes="Cette methode permet de supprimer de Credit par l'id",response= CreditDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="la Credit a ete supprimer")
	})
	void delete(@PathVariable("idCredit") Long id);


}
