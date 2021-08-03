package com.amine.gestionpaie.dto;

import java.util.Collection;
import java.util.Date;

import com.amine.gestionpaie.model.Diplome;
import com.amine.gestionpaie.model.Employe;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DiplomeDto {
	private Long idDiplome;
	private String nomDiplome;
	private String typeDiplome;
	private int nvDiplome;
	private Date dateObtenir;
	@JsonIgnore
	private Collection<EmployeDto> employes;

	private Integer idSociete;
	public static DiplomeDto fromEntity(Diplome diplome) {
		if(diplome==null) {
			return null;
		}
		return DiplomeDto.builder()
				.idDiplome(diplome.getIdDiplome())
				.nomDiplome(diplome.getNomDiplome())
				.typeDiplome(diplome.getTypeDiplome())
				.nvDiplome(diplome.getNvDiplome())
				.dateObtenir(diplome.getDateObtenir())
				
				.build();
	}
	public static Diplome toEntity(DiplomeDto diplomeDto) {
	if(diplomeDto == null) {
		return null;
	}
	Diplome diplome = new Diplome();
	diplome.setIdDiplome(diplomeDto.getIdDiplome());
	diplome.setNomDiplome(diplomeDto.getNomDiplome());
	diplome.setTypeDiplome(diplomeDto.getTypeDiplome());
	diplome.setNvDiplome(diplomeDto.getNvDiplome());
	diplome.setDateObtenir(diplome.getDateObtenir());
	
	return diplome;
	
	}
}
