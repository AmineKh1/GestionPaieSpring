package com.amine.gestionpaie.dto;

import java.util.Date;

import com.amine.gestionpaie.model.anneeConfig.IGR;
import com.amine.gestionpaie.model.anneeConfig.IGRList;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class IGRListDto {
	private Long idtaxI;
	private Double debutTrancheIGR;
	private Double finTrancheIGR;
	private Double tauxIGR;
	private Double valeurIGR;
	private IGRDto igr;
	
	public static IGRListDto fromEntity(IGRList igrList) {
		if(igrList==null) {
			return null;
		}
		return IGRListDto.builder()
				.idtaxI(igrList.getIdtaxI())
				.debutTrancheIGR(igrList.getDebutTrancheIGR())
				.finTrancheIGR(igrList.getFinTrancheIGR())
				.tauxIGR(igrList.getTauxIGR())
				.valeurIGR(igrList.getValeurIGR())
				.igr(IGRDto.fromEntity(igrList.getIgr()))
				.build();
	}
	public static IGRList toEntity(IGRListDto igrListDto) {
		if(igrListDto==null) {
			return null;
		}
		IGRList igrList= new IGRList();
		igrList.setIdtaxI(igrListDto.getIdtaxI());
		igrList.setDebutTrancheIGR(igrListDto.getDebutTrancheIGR());
		igrList.setFinTrancheIGR(igrListDto.getFinTrancheIGR());
		igrList.setTauxIGR(igrListDto.getTauxIGR());
		igrList.setValeurIGR(igrListDto.getValeurIGR());
		igrList.setIgr(IGRDto.toEntity(igrListDto.getIgr()));
		return igrList;
	}
}
