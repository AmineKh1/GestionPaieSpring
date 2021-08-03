package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;

public class DepartementValidator {
	public static List<String> validate(DepartementDto deparetementDto){
		List<String> errors = new ArrayList<>();
			if(deparetementDto == null || !StringUtils.hasLength(deparetementDto.getNomDepart())) {
				errors.add("veuillez renseigner le nom du Departement");
				}
			if(deparetementDto == null || !StringUtils.hasLength(deparetementDto.getSuperviseurDept())) {
				errors.add("veuillez renseigner le nom du superviseur");
				}
			
			
			if(deparetementDto == null || deparetementDto.getSociete()==null) {
				errors.add("veuillez renseigner le id de societe du Departement");
				}
			
			return errors;
	}

}
