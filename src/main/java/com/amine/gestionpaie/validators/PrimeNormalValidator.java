package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;

public class PrimeNormalValidator {
	public static List<String> validate(PrimeNormalDto primeNormalDto){
		List<String> errors = new ArrayList<>();
			if(primeNormalDto == null || !StringUtils.hasLength(primeNormalDto.getNomPrime())) {
				errors.add("veuillez renseigner le nom du Prime");
			}
			if(primeNormalDto == null || !StringUtils.hasLength(primeNormalDto.getCode())) {
				errors.add("veuillez renseigner le code du Prime");
			}
			if(primeNormalDto == null || primeNormalDto.getValeurPrime()==null) {
				errors.add("veuillez renseigner la valeur du Prime");
			}
			
			
			if(primeNormalDto == null || primeNormalDto.getDateAffectationP()==null) {
				errors.add("veuillez renseigner la date du Prime");
			}
			return errors;
		}

}
