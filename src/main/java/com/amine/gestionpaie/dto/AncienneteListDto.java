package com.amine.gestionpaie.dto;


import com.amine.gestionpaie.model.anneeConfig.AncienneteList;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class AncienneteListDto {
	private Long idtax;
	private int debutTrancheAn;
	private int finTrancheAn;
	private Double tauxAnc;
	private AncienneteDto ancienneteDto;
	
	public static AncienneteListDto fromEntity(AncienneteList ancienneteList) {
		if (ancienneteList==null) {
			return null;
		}
		return AncienneteListDto.builder()
				.idtax(ancienneteList.getIdtax())
				.debutTrancheAn(ancienneteList.getDebutTrancheAn())
				.finTrancheAn(ancienneteList.getFinTrancheAn())
				.tauxAnc(ancienneteList.getTauxAnc())
				.ancienneteDto(AncienneteDto.fromEntity(ancienneteList.getAnciennete()))
				.build();
	}
	public static AncienneteList toEntity(AncienneteListDto ancienneteListDto) {
		if(ancienneteListDto==null) {
			return null;
		}
		AncienneteList ancienneteList= new AncienneteList();
		ancienneteList.setIdtax(ancienneteListDto.getIdtax());
		ancienneteList.setDebutTrancheAn(ancienneteListDto.getDebutTrancheAn());
		ancienneteList.setDebutTrancheAn(ancienneteListDto.getFinTrancheAn());
		ancienneteList.setTauxAnc(ancienneteListDto.getTauxAnc());
		ancienneteList.setAnciennete(AncienneteDto.toEntity(ancienneteListDto.getAncienneteDto()));
		return ancienneteList;
	}

}
