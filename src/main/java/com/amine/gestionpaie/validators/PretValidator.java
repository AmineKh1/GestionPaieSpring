package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;

public class PretValidator {
	public static List<String> validate(PretDto pretDto){
		List<String> errors = new ArrayList<>();
			if(pretDto == null || pretDto.getValeurPret()==null) {
				errors.add("veuillez renseigner la valeur du Pret");
			}
			if(pretDto == null || pretDto.getRetenueMensualle()==null) {
				errors.add("veuillez renseigner le retenue mensualle du Pret");
			}
			if(pretDto == null || pretDto.getDateAffectationP()==null) {
				errors.add("veuillez renseigner la valeur du Pret");
			}
			return errors;
		}


}
