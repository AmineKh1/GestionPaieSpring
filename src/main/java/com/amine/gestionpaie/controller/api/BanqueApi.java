package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amine.gestionpaie.dto.BanqueDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/banque")

public interface BanqueApi {
	
	@PostMapping(value = APP_ROOT +"/banque/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Entregister un Banque",notes="Cette methode permet d'enregistrer ou modifier une Banque",response= BanqueDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet Banque creer/modifie"),
			@ApiResponse(code=400, message="L'objet Banque n'est pas valide")
	})
	
	BanqueDto save(@RequestBody BanqueDto dto);
	
	@GetMapping(value = APP_ROOT +"/banque/{idBanque}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Banque par ID",notes="Cette methode permet de chercher une Banque par son ID",response= BanqueDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Banque a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Banque n'existe dans la BBD avec l'ID fourni")
	})
	BanqueDto findById(@PathVariable("idBanque")Long id);
	
	@GetMapping(value = APP_ROOT +"/banque/{nomBanque}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Banque par nom de Banque",notes="Cette methode permet de chercher un Banque par son nom",response= BanqueDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Banque a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Banque n'existe dans la BBD avec le nom de Banque fourni")
	})
	BanqueDto findByNomBanque(@PathVariable("nomBanque") String nomBanque);
	
	@GetMapping(value = APP_ROOT +"/banque/all",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi la liste des Banque",notes="cette methode permet de chrcher et renvoyer la liste des Banque qui existent dans la BBD",responseContainer="List<BanqueDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="La liste des Banques / une Liste vide")
	})
	List<BanqueDto> findAll();
	
	@GetMapping(value = APP_ROOT +"/banque/delete/{idBanque}")
	@ApiOperation(value="Supprimer de Banque",notes="Cette methode permet de supprimer de Banque par l'id",response= BanqueDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="la Banque a ete supprimer")
	})
	void delete(@PathVariable("idBanque") Long id);
}
