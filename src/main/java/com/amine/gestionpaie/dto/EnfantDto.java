package com.amine.gestionpaie.dto;

import java.util.Date;

import com.amine.gestionpaie.model.Enfant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnfantDto {
	private Long idEnfant;
	private Date datedeNaissance;
	private EmployeDto employeEnfant;

	public static EnfantDto fromEntity(Enfant enfant) {
		if(enfant == null) {
			return null;
		}
		return EnfantDto.builder()
				.idEnfant(enfant.getIdEnfant())
				.datedeNaissance(enfant.getDatedeNaissance())
				.employeEnfant(EmployeDto.fromEntity(enfant.getEmployeEnfant()))
				.build();
	}
	public static Enfant toEntity(EnfantDto enfantDto) {
		if(enfantDto == null) {
			return null;
		}
		Enfant enfant=new Enfant();
		enfant.setIdEnfant(enfantDto.getIdEnfant());
		enfant.setDatedeNaissance(enfantDto.getDatedeNaissance());
		enfant.setEmployeEnfant(EmployeDto.toEntity(enfantDto.getEmployeEnfant()));
		return enfant;
	}

}
