package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.PrimeCourantDto;

public class PrimeCourantValidator {
	public static List<String> validate(PrimeCourantDto primeCourantDto){
		List<String> errors = new ArrayList<>();
		if(primeCourantDto == null || !StringUtils.hasLength(primeCourantDto.getNomPrime())) {
			errors.add("veuillez renseigner le nom du Prime");
		}
		if(primeCourantDto == null || !StringUtils.hasLength(primeCourantDto.getCode())) {
			errors.add("veuillez renseigner le code du Prime");
		}
		if(primeCourantDto == null || primeCourantDto.getValeurPrime()==null) {
			errors.add("veuillez renseigner la valeur du Prime");
		}
		if(primeCourantDto==null || primeCourantDto.getPrimeCourantList().isEmpty()) {
			errors.add("veuillez renseigner que le prime ca mrache pour le moment");
		}
		
		
		return errors;
	
	}

}
