package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import com.amine.gestionpaie.dto.*;

public class IGRValidator {
	public static List<String> validate(IGRDto igrDto){
		List<String> errors = new ArrayList<>();
			if(igrDto == null || igrDto.getAnnees()==0) {
				errors.add("veuillez renseigner l'annees");
			}
			
			
			
			return errors;
		}

}
