package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;

public class CongeValidator {
	public static List<String> validate(CongeDto congeDto){
		List<String> errors = new ArrayList<>();
			if(congeDto == null || congeDto.getDureeConge()==0) {
				errors.add("veuillez renseigner la duree du conge");
			}
			
			if(congeDto == null || congeDto.getDateDebut()==null) {
				errors.add("veuillez renseigner la debut de conge");
			}
			if(congeDto == null || congeDto.getDateFin()==null) {
				errors.add("veuillez renseigner la date de fin du conge");
			}
			if(congeDto == null || !StringUtils.hasLength(congeDto.getType())) {
				errors.add("veuillez renseigner le type du conge");
			}
			return errors;
		}
	

}
