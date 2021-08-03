package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amine.gestionpaie.dto.CongeDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/conge")

public interface CongeApi {
	@PostMapping(value = APP_ROOT +"/conge/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Entregister un Conge",notes="Cette methode permet d'enregistrer ou modifier un Conge",response= CongeDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet Conge creer/modifie"),
			@ApiResponse(code=400, message="L'objet Conge n'est pas valide")
	})
	CongeDto save(@RequestBody CongeDto dto);
	@GetMapping(value = APP_ROOT +"/conge/{idConge}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Conge par ID",notes="Cette methode permet de chercher un Conge par son ID",response= CongeDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Conge a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Conge n'existe dans la BBD avec l'ID fourni")
	})
	CongeDto findById(@PathVariable("idConge") Long id);
	@GetMapping(value = APP_ROOT +"/conge/{typeConge}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Conge par type de Conge",notes="Cette methode permet de chercher un Conge par son type",response= CongeDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Conge a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Conge n'existe dans la BBD avec le type de Conge fourni")
	})
	CongeDto findByType(@PathVariable("typeConge")String type);
	@GetMapping(value = APP_ROOT +"/conge/all",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi la liste des Conge",notes="cette methode permet de chrcher et renvoyer la liste des Conge qui existent dans la BBD",responseContainer="List<CongeDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="La liste des Conges / une Liste vide")
	})
	List<CongeDto> findAll();
	@GetMapping(value = APP_ROOT +"/conge/delete/{idConge}")
	@ApiOperation(value="Supprimer de Conge",notes="Cette methode permet de supprimer de Conge par l'id",response= CongeDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="la Conge a ete supprimer")
	})
	void delete(@PathVariable("idConge") Long id);

}
