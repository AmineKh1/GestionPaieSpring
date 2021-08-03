package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;

public class UtilisateurValidator {
	public static List<String> validate(UtilisateurDto utilisateurDto){
		List<String> errors = new ArrayList<>();
			
			if(utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getEmail())) {
				errors.add("veuillez renseigner l'email");
			}
			if(utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getMdp())) {
				errors.add("veuillez renseigner le me de passe du compte");
			}
		
			return errors;
		}

}
