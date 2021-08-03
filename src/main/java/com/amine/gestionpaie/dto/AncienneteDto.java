package com.amine.gestionpaie.dto;

import java.util.Collection;

import com.amine.gestionpaie.model.anneeConfig.Anciennete;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class AncienneteDto {
	private Long idannees;
	private int annees;

	private Collection<AncienneteListDto> ancienneteListDto;
	
	public static AncienneteDto fromEntity(Anciennete anciennete) {
		if(anciennete==null) {
			return null;
		}
		return AncienneteDto.builder()
				.idannees(anciennete.getIdannees())
				.annees(anciennete.getAnnees())
				.build();
	}
	public static Anciennete toEntity(AncienneteDto ancienneteDto) {
		if(ancienneteDto==null) {
			return null;
		}
		Anciennete anciennete= new Anciennete();
		anciennete.setIdannees(ancienneteDto.getIdannees());
		anciennete.setAnnees(ancienneteDto.getAnnees());
		return anciennete;
	}

}
