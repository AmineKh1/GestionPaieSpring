package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;

public class EnfantValidator {
	public static List<String> validate(EnfantDto enfantDto){
		List<String> errors = new ArrayList<>();
			if(enfantDto == null || enfantDto.getDatedeNaissance()==null) {
			errors.add("veuillez renseigner la date de naissance de l'enfant");
		}
		return errors;
	}
		
}
	
