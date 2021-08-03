package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.*;

public class BulletinPaieValidator {
	public static List<String> validate(BulletinPaieDto bulletinPaieDto){
		List<String> errors = new ArrayList<>();
			if(bulletinPaieDto == null || bulletinPaieDto.getDateSaisie()==null) {
				errors.add("veuillez renseigner la date de saisie du bulletin");
				}
			if(bulletinPaieDto == null || bulletinPaieDto.getEmployeBulletinpaie()==null) {
				errors.add("veuillez renseigner l'id de employe");
				}
			
			
			
			return errors;
	}

}
