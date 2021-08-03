package com.amine.gestionpaie.dto;

import com.amine.gestionpaie.model.anneeConfig.Mutuelle;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MutuelleDto {
	private Long idannees;
	private int annees;
	private Double tauxSalarialM;
	private Double tauxPatronalM;
	
	public static MutuelleDto fromEntity(Mutuelle mutuelle) {
		if(mutuelle==null) {
			return null;
		}
		return MutuelleDto.builder()
				.idannees(mutuelle.getIdannees())
				.annees(mutuelle.getAnnees())
				.tauxPatronalM(mutuelle.getTauxSalarialM())
				.tauxPatronalM(mutuelle.getTauxPatronalM())
				.build();
	}
	public static Mutuelle toEntity(MutuelleDto mutuelleDto) {
		if(mutuelleDto==null) {
			return null;
		}
		Mutuelle mutuelle= new Mutuelle();
		mutuelle.setIdannees(mutuelleDto.getIdannees());
		mutuelle.setAnnees(mutuelleDto.getAnnees());
		mutuelle.setTauxSalarialM(mutuelleDto.getTauxSalarialM());
		mutuelle.setTauxPatronalM(mutuelleDto.getTauxPatronalM());
		return mutuelle;
	}

}
