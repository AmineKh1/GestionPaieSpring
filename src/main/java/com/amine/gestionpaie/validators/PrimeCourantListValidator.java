package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.PrimeCourantListDto;

public class PrimeCourantListValidator {
	public static List<String> validate(PrimeCourantListDto primeCourantListDto){
	List<String> errors = new ArrayList<>();
	if(primeCourantListDto==null|| primeCourantListDto.getExist()==null) {
		errors.add("veuillez renseigner le changement du l'etats d prime pour employez");
	}
	if(primeCourantListDto==null|| primeCourantListDto.getIdPrimeCourantList()==null) {
		errors.add("veuillez renseigner l'employer ciblé avec le changement");
		
	}
	
	
	
	

	
	return errors;
}
	
	

}
