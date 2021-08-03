package com.amine.gestionpaie.dto;

import java.util.Collection;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.amine.gestionpaie.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class DepartementDto {
	private Long numDep;
	private String nomDepart;
	private String superviseurDept;
	
	private SocieteDto societe;
	@JsonIgnore
	private Collection<EmployeDto> employes;
	
	public static DepartementDto fromEntity(Departement departement) {
		if(departement==null) {
			return null;
		}
		return DepartementDto.builder()
				
				.nomDepart(departement.getNomDepart())
				.superviseurDept(departement.getSuperviseurDept())
				.societe(SocieteDto.fromEntity(departement.getSociete()))
				.build();
				
	}
	public static Departement toEntity(DepartementDto departementDto) {
		if(departementDto==null) {
			return null;
		}
		Departement departement= new Departement();
		departement.setNomDepart(departementDto.getNomDepart());
		departement.setSuperviseurDept(departementDto.getSuperviseurDept());
		departement.setSociete(SocieteDto.toEntity(departementDto.getSociete()));
		return departement;
	}

}
