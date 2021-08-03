package com.amine.gestionpaie.dto;

import java.util.Date;

import com.amine.gestionpaie.model.anneeConfig.CIMR;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CIMRDto {
	private Long idannees;
	private int annees;
	private Double  tauxSalarial;
	private Double tauxPatronale;
	
	public static CIMRDto fromEntity(CIMR cimr) {
		if(cimr==null) {
			return null;
		}
		return CIMRDto.builder()
				.idannees(cimr.getIdannees())
				.annees(cimr.getAnnees())
				.tauxSalarial(cimr.getTauxSalarial())
				.tauxPatronale(cimr.getTauxPatronale())
				.build();
	}
	
	public static CIMR toEntity(CIMRDto cimrDto) {
		if(cimrDto==null) {
			return null;
		}
		CIMR cimr= new CIMR();
		cimr.setIdannees(cimrDto.getIdannees());
		cimr.setAnnees(cimrDto.getAnnees());
		cimr.setTauxSalarial(cimrDto.getTauxSalarial());
		cimr.setTauxPatronale(cimrDto.getTauxPatronale());
		return cimr;
	}

}
