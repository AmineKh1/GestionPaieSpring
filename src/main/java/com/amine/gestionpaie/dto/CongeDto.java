package com.amine.gestionpaie.dto;

import java.util.Date;

import com.amine.gestionpaie.model.Conge;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CongeDto {
	private Long idConge;
	private int dureeConge;
	private Date dateDebut;
	private Date dateFin;
	private String type;
	private EmployeDto employeConge;
	private Integer idSociete;
	public static CongeDto fromEntity(Conge conge) {
		if(conge == null) {
			return null;
		}
		return CongeDto.builder()
				.idConge(conge.getIdConge())
				.dureeConge(conge.getDureeConge())
				.dateDebut(conge.getDateDebut())
				.dateFin(conge.getDateFin())
				.type(conge.getType())
				.employeConge(EmployeDto.fromEntity(conge.getEmployeConge()))
				.build();
	}
	public static Conge toEntity(CongeDto congeDto) {
		if(congeDto == null) {
			return null;
		}
		Conge conge = new Conge();
		conge.setIdConge(congeDto.getIdConge());
		conge.setDureeConge(congeDto.getDureeConge());
		conge.setDateDebut(congeDto.getDateDebut());
		conge.setDateFin(congeDto.getDateFin());
		conge.setType(congeDto.getType());
		conge.setEmployeConge(EmployeDto.toEntity(congeDto.getEmployeConge()));
		
		return conge;
	}

}
