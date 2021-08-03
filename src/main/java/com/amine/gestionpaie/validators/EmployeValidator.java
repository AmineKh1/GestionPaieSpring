package com.amine.gestionpaie.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amine.gestionpaie.dto.EmployeDto;

public class EmployeValidator {
	public static List<String> validate(EmployeDto employeDto){
		List<String> errors = new ArrayList<>();
			
			if(employeDto == null || !StringUtils.hasLength(employeDto.getNom())) {
				errors.add("veuillez renseigner le nom de l'employe");
			}
			if(employeDto == null || !StringUtils.hasLength(employeDto.getPrenom())) {
				errors.add("veuillez renseigner le prenom de l'employe");
			}
			if(employeDto == null || !StringUtils.hasLength(employeDto.getCin())) {
				errors.add("veuillez renseigner le CIN de l'employe");
			}
			if(employeDto==null || employeDto.getAdresseE()==null) {
				errors.add("veullez renseigner l'adresse d'employer");
			}else {
				if(!StringUtils.hasLength(employeDto.getAdresseE().getAdresse1())) {
					errors.add("le champs Adresse est vide");
				}
				if(!StringUtils.hasLength(employeDto.getAdresseE().getVille())) {
					errors.add("le champs Ville est vide");
				}
				if(!StringUtils.hasLength(employeDto.getAdresseE().getCodePostale())) {
					errors.add("le champs Code postale est vide");
				}
				if(!StringUtils.hasLength(employeDto.getAdresseE().getPays())) {
					errors.add("le champs Pays est vide");
				}
			}
			if(employeDto == null || !(employeDto.getDateNaissance()==null)) {
				errors.add("veuillez renseigner la date de naissance de l'employe");
			}
			if(employeDto == null || !StringUtils.hasLength(employeDto.getSexe())) {
				errors.add("veuillez renseigner le sexe de l'employe");
			}
			if(employeDto == null || employeDto.getSituationFamiliale()==null) {
				errors.add("veuillez renseigner la situation familiale de l'employe");
			}
			if(employeDto == null || !StringUtils.hasLength(employeDto.getEmail())) {
				errors.add("veuillez renseigner l'email de l'employe");
			}
			if(employeDto == null || !StringUtils.hasLength(employeDto.getTel())) {
				errors.add("veuillez renseigner le numero de telephone de l'employe");
			}
			if(employeDto == null || employeDto.getCompteBancaire()== 0) {
				errors.add("veuillez renseigner le numero du compte Bancaire de l'employe");
			}
			if(employeDto == null || employeDto.getNumCnss()==0) {
				errors.add("veuillez renseigner le numero de cnss l'employe");
			}
			if(employeDto == null || employeDto.getNumMutulle()==0) {
				errors.add("veuillez renseigner le Numero de Mutuelle de l'employe");
			}
			return errors;
		}
	

}
