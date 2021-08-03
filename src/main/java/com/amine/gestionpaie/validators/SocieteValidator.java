package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;

public class SocieteValidator {
	public static List<String> validate(SocieteDto societeDto){
		List<String> errors = new ArrayList<>();
			if(societeDto == null || !StringUtils.hasLength(societeDto.getNomSociete())) {
			errors.add("veuillez renseigner le nom du societe");
			}
			if(societeDto == null || !StringUtils.hasLength(societeDto.getNomSociete())) {
				errors.add("veuillez renseigner le nom du societe");
			}
			if(societeDto==null || societeDto.getAdresseS()==null) {
				errors.add("veullez renseigner l'adresse d'employer");
			}else {
				if(!StringUtils.hasLength(societeDto.getAdresseS().getAdresse1())) {
					errors.add("le champs Adresse est vide");
				}
				if(!StringUtils.hasLength(societeDto.getAdresseS().getVille())) {
					errors.add("le champs Ville est vide");
				}
				if(!StringUtils.hasLength(societeDto.getAdresseS().getCodePostale())) {
					errors.add("le champs Code postale est vide");
				}
				if(!StringUtils.hasLength(societeDto.getAdresseS().getPays())) {
					errors.add("le champs Pays est vide");
				}
			}
			if(societeDto == null || !StringUtils.hasLength(societeDto.getTelSociete())) {
				errors.add("veuillez renseigner le numero de telephone du societe");
			}
			if(societeDto == null || !StringUtils.hasLength(societeDto.getEmailSociete())) {
				errors.add("veuillez renseigner l'email du societe");
			}
			
			
		
			
			return errors;
	}

}
