package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;

public class CreditValidator {
	public static List<String> validate(CreditDto creditDto){
		List<String> errors = new ArrayList<>();
			if(creditDto == null || creditDto.getValeurCredit()==null) {
				errors.add("veuillez renseigner la valeur du credit");
			}
			if(creditDto == null || creditDto.getTauxInteret()==null) {
				errors.add("veuillez renseigner le taux d'interet ");
			}
			if(creditDto == null || creditDto.getDateAffectation()==null) {
				errors.add("veuillez renseigner la Date d'affectation");
			}
			
			return errors;
		}


}
