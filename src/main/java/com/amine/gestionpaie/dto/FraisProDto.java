package com.amine.gestionpaie.dto;

import com.amine.gestionpaie.model.anneeConfig.FraisPro;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FraisProDto {
	private Long idannees;
	private int annees;
	private Double tauxFrais;
	private Double Plafond;
	public static FraisProDto fromEntity(FraisPro fraisPro) {
		if(fraisPro==null) {
			return null;
		}
		return FraisProDto.builder()
				.idannees(fraisPro.getIdannees())
				.annees(fraisPro.getAnnees())
				.tauxFrais(fraisPro.getTauxFrais())
				.Plafond(fraisPro.getPlafond())
				.build();
	}
	public static FraisPro toEntity(FraisProDto fraisProDto) {
		if(fraisProDto==null) {
			return null;
		}
		FraisPro fraisPro= new FraisPro();
		fraisPro.setIdannees(fraisProDto.getIdannees());
		fraisPro.setAnnees(fraisProDto.getAnnees());
		fraisPro.setTauxFrais(fraisProDto.getTauxFrais());
		fraisPro.setPlafond(fraisProDto.getPlafond());
		return fraisPro;
		
	}

}
