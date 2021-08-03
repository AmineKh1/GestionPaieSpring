package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.amine.gestionpaie.dto.*;

public class AncienneteListValidator {
	public static List<String> validate(Collection<AncienneteListDto> collection){
		List<String> errors = new ArrayList<>();
			if(collection == null || ((AncienneteListDto) collection).getDebutTrancheAn()==0) {
				errors.add("veuillez renseigner la debut du tranche");
			}
			if(collection == null || ((AncienneteListDto) collection).getFinTrancheAn()==0) {
				errors.add("veuillez renseigner la fin du trachee");
			}
			if(collection == null || ((AncienneteListDto) collection).getTauxAnc()==null) {
				errors.add("veuillez renseigner le taux du tranche");
			}
	
			return errors;
		}

}
