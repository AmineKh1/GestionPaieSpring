package com.amine.gestionpaie.dto;

import com.amine.gestionpaie.model.anneeConfig.CNSS;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CNSSDto{
	private Long idannees;
	private int annees;
	private Double  tauxSalarialSP;
	private Double plafondSalarialSP;
	private Double tauxPatronaleSP;
	private Double taxPatronalAF;
	private Double tauxPatronalFP;
	
	public static CNSSDto fromEntity(CNSS cnss) {
		if(cnss == null) {
			return null;
		}
		return CNSSDto.builder()
				.idannees(cnss.getIdannees())
				.annees(cnss.getAnnees())
				.tauxPatronaleSP(cnss.getTauxSalarialSP())
				.plafondSalarialSP(cnss.getPlafondSalarialSP())
				.tauxPatronaleSP(cnss.getTauxPatronaleSP())
				.taxPatronalAF(cnss.getTaxPatronalAF())
				.tauxPatronalFP(cnss.getTauxPatronalFP())
				.build();
	}
	public static CNSS toEntity(CNSSDto cnssDto) {
		if(cnssDto==null) {
			return null;
		}
		CNSS cnss= new CNSS();
		cnss.setIdannees(cnssDto.getIdannees());
		cnss.setAnnees(cnssDto.getAnnees());
		cnss.setPlafondSalarialSP(cnssDto.getTauxSalarialSP());
		cnss.setTauxPatronaleSP(cnss.getTauxPatronaleSP());
		cnss.setTaxPatronalAF(cnss.getTaxPatronalAF());
		cnss.setTauxPatronalFP(cnssDto.getTauxPatronalFP());
		return cnss;
	}

}
