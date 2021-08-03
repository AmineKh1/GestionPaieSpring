package com.amine.gestionpaie.dto;

import java.util.Date;

import com.amine.gestionpaie.model.Credit;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditDto {
	private Long idCredit;
	private Double ValeurCredit;
	private Double TauxInteret;
	private Date dateAffectation;

	private EmployeDto employeCredit;
	public static CreditDto fromEntity(Credit credit) {
		if(credit == null ) {
			return null;
		}
		return CreditDto.builder()
				.idCredit(credit.getIdCredit())
				.ValeurCredit(credit.getValeurCredit())
				.TauxInteret(credit.getTauxInteret())
				.dateAffectation(credit.getDateAffectation())
				.employeCredit(EmployeDto.fromEntity(credit.getEmployeCredit()))
				.build();
	}
	public static Credit toEntity(CreditDto creditDto) {
		if (creditDto == null) {
			return null;
		}
		Credit credit = new Credit();
		credit.setIdCredit(creditDto.getIdCredit());
		credit.setValeurCredit(creditDto.getValeurCredit());
		credit.setTauxInteret(creditDto.getTauxInteret());
		credit.setDateAffectation(creditDto.getDateAffectation());
		credit.setEmployeCredit(EmployeDto.toEntity(creditDto.getEmployeCredit()));
		return credit;
	}

}
