package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;

public class ContratValidator {
	public static List<String> validate(ContratDto contratDto){
		List<String> errors = new ArrayList<>();
			if(contratDto == null || contratDto.getDateEmbauche()==null) {
				errors.add("veuillez renseigner la date d'Embauche de contrat");
			}
			if(contratDto == null || contratDto.getSalaireBase()==0) {
				errors.add("veuillez renseigner le salaire base de contrat");
			}
			if(contratDto == null || !StringUtils.hasLength(contratDto.getTypeContrat())) {
				errors.add("veuillez renseigner le type de contrat");
			}
			if(contratDto == null || !StringUtils.hasLength(contratDto.getProfession())) {
				errors.add("veuillez renseigner la Profession d'emploi dans la contrat");
			}
			return errors;
		}

}
