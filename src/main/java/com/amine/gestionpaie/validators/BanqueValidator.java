package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;

public class BanqueValidator {
	public static List<String> validate(BanqueDto banqueDto){
		List<String> errors = new ArrayList<>();
			if(banqueDto == null || !StringUtils.hasLength(banqueDto.getNomBanque())) {
				errors.add("veuillez renseigner le nom du Banque");
				}
			if(banqueDto==null || banqueDto.getAdresseB()==null) {
				errors.add("veullez renseigner l'adresse d'employer");
			}else {
				if(!StringUtils.hasLength(banqueDto.getAdresseB().getAdresse1())) {
					errors.add("le champs Adresse est vide");
				}
				if(!StringUtils.hasLength(banqueDto.getAdresseB().getVille())) {
					errors.add("le champs Ville est vide");
				}
				if(!StringUtils.hasLength(banqueDto.getAdresseB().getCodePostale())) {
					errors.add("le champs Code postale est vide");
				}
				if(!StringUtils.hasLength(banqueDto.getAdresseB().getPays())) {
					errors.add("le champs Pays est vide");
				}
			}
			if(banqueDto == null || banqueDto.getFax()==0) {
				errors.add("veuillez renseigner le numero de fax du Banque");
				}
			if(banqueDto == null || !StringUtils.hasLength(banqueDto.getTelBanque())) {
				errors.add("veuillez renseigner le numero de telephone du Banque");
				}
			
			
			return errors;
	}

}
