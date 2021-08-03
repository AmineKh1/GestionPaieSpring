package com.amine.gestionpaie.dto;

import java.util.Collection;
import java.util.Date;

import com.amine.gestionpaie.model.anneeConfig.IGR;
import com.amine.gestionpaie.model.anneeConfig.IGRList;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class IGRDto{
	private Long idannees;
	private int annees;
	private Double fraisFamille;
	@JsonIgnore
	private Collection<IGRListDto> igrList;
	public static IGRDto fromEntity(IGR igr) {
		if(igr==null) {
			return null;
		}
		return IGRDto.builder()
				.idannees(igr.getIdannees())
				.annees(igr.getAnnees())
				.fraisFamille(igr.getFraisFamille())
				.build();
	}
	public static IGR toEntity(IGRDto igrDto) {
		if(igrDto==null) {
			return null;
		}
		IGR igr= new IGR();
		igr.setIdannees(igrDto.getIdannees());
		igr.setAnnees(igrDto.getAnnees());
		igr.setFraisFamille(igrDto.getFraisFamille());
		return igr;
	}

}
