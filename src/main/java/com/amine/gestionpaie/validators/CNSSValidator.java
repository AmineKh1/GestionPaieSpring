package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import com.amine.gestionpaie.dto.*;

public class CNSSValidator {
	public static List<String> validate(CNSSDto cnssDto){
		List<String> errors = new ArrayList<>();
			if(cnssDto == null || cnssDto.getAnnees()==0) {
				errors.add("veuillez renseigner l'annees");
			}
			if(cnssDto == null || cnssDto.getTauxSalarialSP()==null) {
				errors.add("veuillez renseigner le taux salarial de Prestations Sociales court et long terme");
			}
			if(cnssDto == null || cnssDto.getPlafondSalarialSP()==null) {
				errors.add("veuillez renseigner le Plafond salarial de Prestations Sociales court et long terme");
			}
			if(cnssDto == null || cnssDto.getTauxPatronaleSP()==null) {
				errors.add("veuillez renseigner le taux Patronale de Prestations Sociales court et long terme");
			}
			if(cnssDto == null || cnssDto.getTaxPatronalAF()==null) {
				errors.add("veuillez renseigner le taux Patronale de Allocations Familliale");
			}
			if(cnssDto == null || cnssDto.getTauxPatronalFP()==null) {
				errors.add("veuillez renseigner le taux Patronale de formation professionnelle");
			}
			
			return errors;
		}

}
