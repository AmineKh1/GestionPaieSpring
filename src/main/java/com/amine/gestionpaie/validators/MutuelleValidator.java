package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import com.amine.gestionpaie.dto.*;

public class MutuelleValidator {
	public static List<String> validate(MutuelleDto mutuelleDto){
		List<String> errors = new ArrayList<>();
			if(mutuelleDto == null || mutuelleDto.getAnnees()==0) {
				errors.add("veuillez renseigner l'annees");
			}
			if(mutuelleDto == null || mutuelleDto.getTauxSalarialM()==null) {
				errors.add("veuillez renseigner le taux salariale du mutuelle");
			}
			if(mutuelleDto == null || mutuelleDto.getTauxPatronalM()==null) {
				errors.add("veuillez renseigner le taux patronal du mutualle");
			}
			
			
			return errors;
		}

}
