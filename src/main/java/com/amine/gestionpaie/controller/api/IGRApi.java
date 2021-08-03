package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amine.gestionpaie.dto.IGRDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/igrParametre")

public interface IGRApi {
	@PostMapping(value = APP_ROOT +"/igrParametre/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Entregister une List IGR paramètre",notes="Cette methode permet d'enregistrer ou modifier une liste IGR Paramètre",response= IGRDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet List IGR Paramètre creer/modifie"),
			@ApiResponse(code=400, message="L'objet List IGR Paramètre n'est pas valide")
	})

	IGRDto save(@RequestBody IGRDto dto);
	@GetMapping(value = APP_ROOT +"/igrParametre/{idannee}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un IGR paramètre par ID",notes="Cette methode permet de chercher un IGR Paramètre par son ID",response= IGRDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " IGR Paramètre a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun IGR Paramètre n'existe dans la BBD avec l'ID fourni")
	})
	IGRDto findById(@PathVariable("idannee") Long id);
	@GetMapping(value = APP_ROOT +"/igrParametre/{annee}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un IGR paramètre par Annee",notes="Cette methode permet de chercher un IGR Paramètre par son Annee",response= IGRDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " IGR Paramètre a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun IGR Paramètre n'existe dans la BBD avec l'annee fourni")
	})
	IGRDto findByAnnee(@PathVariable("annee") int annee);
	@GetMapping(value = APP_ROOT +"/igrParametre/all",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi la liste des paramètres de IGR",notes="cette methode permet de chrcher et renvoyer la liste des paramètre de IGR qui existent dans la BBD",responseContainer="List<IGRDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="La liste des IGR / une Liste vide")
	})
	List<IGRDto> findAll();
	@GetMapping(value = APP_ROOT +"/igrParametre/delete/{idannee}")
	@ApiOperation(value="Supprimer un Paramètre de IGR",notes="Cette methode permet de supprimer un paramètre de IGR par l'id",response= IGRDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Paramètre de IGR a ete supprimer")
	})
	void delete(@PathVariable("idannee") Long id);

}
