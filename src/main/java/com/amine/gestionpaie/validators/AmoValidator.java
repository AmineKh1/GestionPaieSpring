package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;

public class AmoValidator {
	public static List<String> validate(AMODto amoDto){
		List<String> errors = new ArrayList<>();
			if(amoDto == null || amoDto.getAnnees()==0) {
				errors.add("veuillez renseigner l'annees");
			}
			if(amoDto == null || amoDto.getTauxAmoSalarial()==null) {
				errors.add("veuillez renseigner le taux Amo salarial");
			}
			if(amoDto == null || amoDto.getTauxAmoPatronale()==null) {
				errors.add("veuillez renseigner le taux d'amo Patronale");
			}
			if(amoDto == null || amoDto.getTauxPartipation()==null) {
				errors.add("veuillez renseigner le taux de participation");
			}
			
			return errors;
		}

}
