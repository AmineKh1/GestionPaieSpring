package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.amine.gestionpaie.dto.DepartementDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/departement")

public interface DepartementApi {
	@PostMapping(value = APP_ROOT +"/departement/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Entregister un Departement",notes="Cette methode permet d'enregistrer ou modifier une Departement",response= DepartementDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet Departement creer/modifie"),
			@ApiResponse(code=400, message="L'objet Departement n'est pas valide")
	})
	DepartementDto save(DepartementDto dto);
	@GetMapping(value = APP_ROOT +"/departement/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Departement par ID",notes="Cette methode permet de chercher une Departement par son ID",response= DepartementDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Departement a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Departement n'existe dans la BBD avec l'ID fourni")
	})
	DepartementDto findById(Long id);
	@GetMapping(value = APP_ROOT +"/departement/all",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi la liste des Departement",notes="cette methode permet de chrcher et renvoyer la liste des Departement qui existent dans la BBD",responseContainer="List<DepartementDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="La liste des Departements / une Liste vide")
	})
	List<DepartementDto> findAll();
	@GetMapping(value = APP_ROOT +"/departement/delete/{id}")
	@ApiOperation(value="Supprimer de Departement",notes="Cette methode permet de supprimer de Departement par l'id",response= DepartementDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="le Departement a ete supprimer")
	})
	void delete(Long id);
	@PostMapping(value = APP_ROOT +"/departement/all{idSociete}", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi les Departements d'une Societe",notes="cette methode permet de chrcher et renvoyer les Departements d'une societe qui existent dans la BBD",responseContainer="List<SocieteDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="les Departement d'une societe / une Liste vide"),
			@ApiResponse(code=404, message="Aucune societe n'existe dans la BBD avec l'ID fourni")

	})
	List<DepartementDto> findAllByIdSociete(Long idSociete);

}
