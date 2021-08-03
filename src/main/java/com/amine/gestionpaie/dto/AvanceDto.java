package com.amine.gestionpaie.dto;

import java.util.Date;

import com.amine.gestionpaie.model.Avance;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AvanceDto {
	private Long idAvance;
	private Double valeurAvance;
	private Date dateAffectionA;
	private EmployeDto employeAvance;
	public static AvanceDto fromEntity(Avance avance) {
		if(avance==null) {
			return null;
		}
		return AvanceDto.builder()
				.idAvance(avance.getIdAvance())
				.valeurAvance(avance.getValeurAvance())
				.dateAffectionA(avance.getDateAffectionA())
				.employeAvance(EmployeDto.fromEntity(avance.getEmployeAvance()))
				.build();
	}
	public static Avance toEntity(AvanceDto avanceDto) {
		if(avanceDto == null) {
			return null;
		}
		Avance avance = new Avance();
		avance.setIdAvance(avanceDto.getIdAvance());
		avance.setValeurAvance(avance.getValeurAvance());
		avance.setDateAffectionA(avance.getDateAffectionA());
		avance.setEmployeAvance(EmployeDto.toEntity(avanceDto.getEmployeAvance()));
		return avance;
	}

}
