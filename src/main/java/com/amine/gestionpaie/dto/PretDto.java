package com.amine.gestionpaie.dto;

import java.util.Date;

import com.amine.gestionpaie.model.Pret;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PretDto {
	private Long idPret;
	private Double valeurPret;
	private Double retenueMensualle;
	private Date dateAffectationP;
	private Date datePayP;
	private EmployeDto employePret;
	public static PretDto fromEntity(Pret pret) {
		if(pret == null) {
			return null;
		}
		return PretDto.builder()
				.idPret(pret.getIdPret())
				.valeurPret(pret.getValeurPret())
				.retenueMensualle(pret.getRetenueMensualle())
				.dateAffectationP(pret.getDateAffectationP())
				.employePret(EmployeDto.fromEntity(pret.getEmployePret()))
				.build();
	}
	
	public static Pret toEntity (PretDto pretDto) {
		if(pretDto == null) {
			return null;
			
		}
		Pret pret= new Pret();
		pret.setIdPret(pretDto.getIdPret());
		pret.setValeurPret(pretDto.getValeurPret());
		pret.setRetenueMensualle(pretDto.getRetenueMensualle());
		pret.setDateAffectationP(pretDto.getDateAffectationP());
		pret.setEmployePret(EmployeDto.toEntity(pretDto.getEmployePret()));
		return pret;
	}

}
