package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;

public class AvanceValidator {
	public static List<String> validate(AvanceDto avanceDto){
		List<String> errors = new ArrayList<>();
			if(avanceDto == null || avanceDto.getValeurAvance()==null) {
				errors.add("veuillez renseigner la valeur d'avance");
			}
			if(avanceDto == null || avanceDto.getDateAffectionA()==null) {
				errors.add("veuillez renseigner la date d'affectation d'avance");
			}
			
			return errors;
		}


}
