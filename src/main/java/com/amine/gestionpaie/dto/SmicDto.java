package com.amine.gestionpaie.dto;

import com.amine.gestionpaie.model.anneeConfig.Smic;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmicDto {
	private Long idannees;
	private int annees;
	private Double valeurSmig;
	public static SmicDto fromEntity(Smic smic) {
		if(smic==null) {
			return null;
		}
		return SmicDto.builder()
				.idannees(smic.getIdannees())
				.annees(smic.getAnnees())
				.valeurSmig(smic.getValeurSmig())
				.build();
	}
	public static Smic toEntity(SmicDto smicDto) {
		if(smicDto==null) {
			return null;
		}
		Smic smic=new Smic();
		smic.setIdannees(smicDto.getIdannees());
		smic.setAnnees(smicDto.getAnnees());
		smic.setValeurSmig(smic.getValeurSmig());
		return smic;
	}
}
