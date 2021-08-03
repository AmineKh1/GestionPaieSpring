package com.amine.gestionpaie.dto;

import java.util.Date;

import com.amine.gestionpaie.model.Prime;
import com.amine.gestionpaie.model.PrimeNormal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrimeNormalDto {
	private Long idPrime;
	private String nomPrime;
	private String code;
	private Double valeurPrime;
	private Date dateAffectationP;

	private EmployeDto employePrime;
	
	public static PrimeNormalDto fromEntity(PrimeNormal prime) {
		if(prime == null) {
			return null;
			
		}
		return PrimeNormalDto.builder()
				.idPrime(prime.getIdPrime())
				.nomPrime(prime.getNomPrime())
				.code(prime.getCode())
				.valeurPrime(prime.getValeurPrime())
				.dateAffectationP(prime.getDateAffectationP())
				.employePrime(EmployeDto.fromEntity(prime.getEmployePrime()))
				.build();
	}
	public static PrimeNormal toEntity(PrimeNormalDto primeNormalDto) {
		if(primeNormalDto == null) {
			return null;
		}
		PrimeNormal prime = new PrimeNormal();
		prime.setIdPrime(primeNormalDto.getIdPrime());
		prime.setNomPrime(primeNormalDto.getNomPrime());
		prime.setCode(primeNormalDto.getCode());
		prime.setValeurPrime(primeNormalDto.getValeurPrime());
		prime.setDateAffectationP(primeNormalDto.getDateAffectationP());
		prime.setEmployePrime(EmployeDto.toEntity(primeNormalDto.getEmployePrime()));
		return prime;
	}

}
