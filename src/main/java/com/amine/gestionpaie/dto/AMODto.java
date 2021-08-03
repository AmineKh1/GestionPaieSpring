package com.amine.gestionpaie.dto;

import com.amine.gestionpaie.model.anneeConfig.AMO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AMODto {
	private Long idannees;
	private int annees;
	private Double tauxAmoSalarial;
	private Double tauxAmoPatronale;
	private Double tauxPartipation;
	
	public static AMODto fromEntity(AMO amo) {
		if (amo==null) {
			return null;
		}
		return AMODto.builder()
				.idannees(amo.getIdannees())
				.annees(amo.getAnnees())
				.tauxAmoSalarial(amo.getTauxAmoSalarial())
				.tauxAmoPatronale(amo.getTauxAmoPatronale())
				.tauxPartipation(amo.getTauxPartipation())
				.build();
	}
	public static AMO toEntity(AMODto amoDto) {
		if(amoDto==null) {
			return null;
		}
		AMO amo= new AMO();
		amo.setIdannees(amoDto.getIdannees());
		amo.setAnnees(amoDto.getAnnees());
		amo.setTauxAmoSalarial(amoDto.getTauxAmoSalarial());
		amo.setTauxAmoPatronale(amoDto.getTauxAmoPatronale());
		amo.setTauxPartipation(amoDto.getTauxPartipation());
		return amo;
		
	}

}
