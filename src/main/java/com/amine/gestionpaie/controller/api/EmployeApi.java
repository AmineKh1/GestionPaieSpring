package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.amine.gestionpaie.dto.EmployeDto;
import com.amine.gestionpaie.dto.SocieteDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/employe")

public interface EmployeApi {
	@PostMapping(value = APP_ROOT +"/employe/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Entregister un Employe",notes="Cette methode permet d'enregistrer ou modifier une Employe",response= EmployeDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet Employe creer/modifie"),
			@ApiResponse(code=400, message="L'objet Employe n'est pas valide")
	})
	EmployeDto save(@RequestBody EmployeDto dto);
	@GetMapping(value = APP_ROOT +"/employe/{idEmploye}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Employe par ID",notes="Cette methode permet de chercher une Employe par son ID",response= EmployeDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Employe a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Employe n'existe dans la BBD avec l'ID fourni")
	})
	EmployeDto findById(@PathVariable("idEmploye") Long id);
	@GetMapping(value = APP_ROOT +"/employe/{cinEmploye}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Employe par nom de Employe",notes="Cette methode permet de chercher un Employe par son nom",response= EmployeDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Employe a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Employe n'existe dans la BBD avec le nom de Employe fourni")
	})
	EmployeDto findBycin(@PathVariable("cinEmploye") String cin);
	@GetMapping(value = APP_ROOT +"/employe/all",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi la liste des Employe",notes="cette methode permet de chrcher et renvoyer la liste des Employe qui existent dans la BBD",responseContainer="List<EmployeDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="La liste des Employes / une Liste vide")
	})
	List<EmployeDto> findAll();
	@GetMapping(value = APP_ROOT +"/employe/delete/{idEmploye}")
	@ApiOperation(value="Supprimer de Employe",notes="Cette methode permet de supprimer de Employe par l'id",response= EmployeDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="l'employer a ete supprimer")
	})
	void delete(Long id);
	
	@PostMapping(value = APP_ROOT +"/employe/all{idSociete}", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi les Employers d'une Societe",notes="cette methode permet de chrcher et renvoyer les Employers d'une societe qui existent dans la BBD",responseContainer="List<SocieteDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="les Employers d'une societe / une Liste vide"),
			@ApiResponse(code=404, message="Aucune societe n'existe dans la BBD avec l'ID fourni")

	})
	List<EmployeDto> findAllByIdSociete(Long idSociete);
	@PostMapping(value = APP_ROOT +"/employe/all{idBanque}", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi les Employers d'une Banque",notes="cette methode permet de chrcher et renvoyer les Employers d'une liste d'anciennete qui existent dans la BBD",responseContainer="List<BanqueDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="les Employers d'une banque / une Liste vide"),
			@ApiResponse(code=404, message="Aucune Banque n'existe dans la BBD avec l'ID fourni")

	})
	List<EmployeDto> findAllByIdBanque(Long idBanque);
	@PostMapping(value = APP_ROOT +"/employe/all{idDepartement}", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi les Employers d'un departement",notes="cette methode permet de chrcher et renvoyer les Employers d'une liste d'anciennete qui existent dans la BBD",responseContainer="List<DepartementDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="les Employers d'un departement / une Liste vide"),
			@ApiResponse(code=404, message="Aucun departement n'existe dans la BBD avec l'ID fourni")

	})
	List<EmployeDto> findAllByIdDepartement(Long idDepartement);

}
