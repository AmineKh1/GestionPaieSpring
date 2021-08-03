package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.amine.gestionpaie.dto.AncienneteListDto;
import com.amine.gestionpaie.dto.BulletinPaieDto;
import com.amine.gestionpaie.dto.EmployeDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/bulletinPaie")

public interface BulletinPaieApi {
	@PostMapping(value = APP_ROOT +"/bulletinPaie/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Entregister un bulletin de paie",notes="Cette methode permet d'enregistrer ou modifier un bulletin paie",response= BulletinPaieDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet bulletin de paie creer/modifie"),
			@ApiResponse(code=400, message="L'objet bulletin de paie n'est pas valide")
	})
	BulletinPaieDto save(BulletinPaieDto dto);
	@GetMapping(value = APP_ROOT +"/bulletinPaie/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un bulletin de paie par ID",notes="Cette methode permet de chercher un bulletin de paie par son ID",response= BulletinPaieDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " bulletin de paie a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun bulletin de paie n'existe dans la BBD avec l'ID fourni")
	})
	BulletinPaieDto findById(Long id);
	@PostMapping(value = APP_ROOT +"/BulletinPaie/all{idEmploye}", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi les bulletin de paie d'un employer",notes="cette methode permet de chrcher et renvoyer les bulletin de paie d'un employer qui existent dans la BBD",responseContainer="List<DepartementDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="les bulletin de paie d'un employer / une Liste vide"),
			@ApiResponse(code=404, message="Aucun bulletin de paie n'existe dans la BBD avec l'ID d'employant fourni")

	})
	List<BulletinPaieDto> findAllByIdEmploye(Long IdEmploye);
	@PostMapping(value = APP_ROOT +"/BulletinPaie/{idEmploye}and{date}", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi les bulletin de paie d'un employer dans une date",notes="cette methode permet de chrcher et renvoyer les bulletin de paie d'un employer dans une date priciser qui existent dans la BBD",responseContainer="List<DepartementDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="les bulletin de paie d'un employer sur la date {date} / une Liste vide"),
			@ApiResponse(code=404, message="Aucun bulletin de paie dans la date {date} n'existe dans la BBD avec l'ID d'employant fourni")

	})
	BulletinPaieDto findByIdEmployefindByDate(Long idEmploye, Date date);
	@GetMapping(value = APP_ROOT +"/bulletinPaie/{idEmploye}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi un bulletin de paie",notes="cette methode permet de chrcher et renvoyer le bulletin de paie qui existent dans la BBD",response= BulletinPaieDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="aucun  bulletin paie exist")
	})
	List<BulletinPaieDto> findAll();
	@GetMapping(value = APP_ROOT +"/bulletinPaie/delete/{id}")
	@ApiOperation(value="Supprimer d'un bulletin de paie",notes="Cette methode permet de supprimer d'un bulletin de paie par l'id",response= BulletinPaieDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="bulletin de paie a ete supprimer")
	})
	void delete(Long id);
	@GetMapping(value = APP_ROOT +"/BulletinPaie/deleteall/all{idEmploye}")
	@ApiOperation(value="Supprimer les bulletin de paie d'un employant",notes="Cette methode permet de supprimer les bulletin de paie d'un emplyant par l'id",response= BulletinPaieDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="les bulletin de paie d'employant avec id {idEmploye} a ete supprimer"),
			@ApiResponse(code=404, message="Aucune bulletin de paie de employant avec l'id {idEmploye} n'existe dans la BBD avec l'ID fourni")

	})
	void deleteAllByIdEmploye(Long idEmploye);

}
