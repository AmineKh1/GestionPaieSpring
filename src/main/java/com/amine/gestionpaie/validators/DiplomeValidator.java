package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;

public class DiplomeValidator {
	public static List<String> validate(DiplomeDto diplomeDto){
		List<String> errors = new ArrayList<>();
			if(diplomeDto == null || !StringUtils.hasLength(diplomeDto.getNomDiplome())) {
				errors.add("veuillez renseigner le nom de diplome");
			}
			if(diplomeDto == null || !StringUtils.hasLength(diplomeDto.getTypeDiplome())) {
				errors.add("veuillez renseigner le type de diplome");
			}
			if(diplomeDto == null || diplomeDto.getNvDiplome()==0) {
				errors.add("veuillez renseigner le niveau de diplome");
			}
			if(diplomeDto == null || diplomeDto.getDateObtenir()==null) {
				errors.add("veuillez renseigner la date d'obtenir du diplome");
			}
			
			return errors;
		}


}
