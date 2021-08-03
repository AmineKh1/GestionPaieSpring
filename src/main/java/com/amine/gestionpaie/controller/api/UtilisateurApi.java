package com.amine.gestionpaie.controller.api;

import static com.amine.gestionpaie.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amine.gestionpaie.dto.UtilisateurDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT+"/utilisateur")

public interface UtilisateurApi {
	@PostMapping(value = APP_ROOT +"/utilisateur/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Entregister un Utilisateur",notes="Cette methode permet d'enregistrer ou modifier un Utilisateur",response= UtilisateurDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= "L'objet Utilisateur creer/modifie"),
			@ApiResponse(code=400, message="L'objet Utilisateur n'est pas valide")
	})
	UtilisateurDto save(@RequestBody UtilisateurDto dto);
	@GetMapping(value = APP_ROOT +"/utilisateur/{idutilisateur}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Utilisateur par ID",notes="Cette methode permet de chercher un Utilisateur par son ID",response= UtilisateurDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Utilisateur a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Utilisateur n'existe dans la BBD avec l'ID fourni")
	})
	UtilisateurDto findById(@PathVariable("idUtilisateur") Long id);
	@GetMapping(value = APP_ROOT +"/utilisateur/{emailtilisateur}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Utilisateur par email de Utilisateur",notes="Cette methode permet de chercher un Utilisateur par son email",response= UtilisateurDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message= " Utilisateur a ete trouve dans la BBD"),
			@ApiResponse(code=404, message="Aucun Utilisateur n'existe dans la BBD avec le nom de Utilisateur fourni")
	})
	UtilisateurDto findByEmail(@PathVariable("EmailUtilisateur")String email);
	@GetMapping(value = APP_ROOT +"/utilisateur/all",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi la liste des Utilisateur",notes="cette methode permet de chrcher et renvoyer la liste des Utilisateur qui existent dans la BBD",responseContainer="List<UtilisateurDto>")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="La liste des Utilisateurs / une Liste vide")
	})
	List<UtilisateurDto> findAll();
	@GetMapping(value = APP_ROOT +"/utilisateur/delete/{idUtilisateur}")
	@ApiOperation(value="Supprimer de Utilisateur",notes="Cette methode permet de supprimer de Utilisateur par l'id",response= UtilisateurDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="la Utilisateur a ete supprimer")
	})
	void delete(@PathVariable("idUtilisateur") Long id);


}
