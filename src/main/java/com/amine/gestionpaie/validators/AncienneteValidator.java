package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;

public class AncienneteValidator {
	public static List<String> validate(AncienneteDto acienneteDto){
		List<String> errors = new ArrayList<>();
			if(acienneteDto == null || acienneteDto.getAnnees()==0) {
				errors.add("veuillez renseigner l'annees");
			}
			
			return errors;
		}

}
