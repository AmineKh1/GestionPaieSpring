package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;

public class IGRListValidator {
	public static List<String> validate(Collection<IGRListDto> collection){
		List<String> errors = new ArrayList<>();
			if(collection == null || ((IGRListDto) collection).getDebutTrancheIGR()==null) {
				errors.add("veuillez renseigner la debut du tranche");
			}
			if(collection == null || ((IGRListDto) collection).getFinTrancheIGR()==null) {
				errors.add("veuillez renseigner la fin du tranche");
			}
			if(collection == null || ((IGRListDto) collection).getTauxIGR()==null) {
				errors.add("veuillez renseigner le taux du tranche");
			}
		
			return errors;
		}

}
