package com.amine.gestionpaie.dto;

import java.util.Date;

import com.amine.gestionpaie.model.PrimeNoExo;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class PrimeNoExoDto {
	private Long idPrime;
	private String nomPrime;
	private String code;
	private Double valeurPrime;
	private Date dateAffectationP;

	private EmployeDto employePrime;
	
	public static PrimeNoExoDto fromEntity(PrimeNoExo prime) {
		if(prime == null) {
			return null;
			
		}
		return PrimeNoExoDto.builder()
				.idPrime(prime.getIdPrime())
				.nomPrime(prime.getNomPrime())
				.code(prime.getCode())
				.valeurPrime(prime.getValeurPrime())
				.dateAffectationP(prime.getDateAffectationP())
				.employePrime(EmployeDto.fromEntity(prime.getEmployePrime()))
				.build();
	}
	public static PrimeNoExo toEntity(PrimeNoExoDto PrimeNoExoDto) {
		if(PrimeNoExoDto == null) {
			return null;
		}
		PrimeNoExo prime = new PrimeNoExo();
		prime.setIdPrime(PrimeNoExoDto.getIdPrime());
		prime.setNomPrime(PrimeNoExoDto.getNomPrime());
		prime.setCode(PrimeNoExoDto.getCode());
		prime.setValeurPrime(PrimeNoExoDto.getValeurPrime());
		prime.setDateAffectationP(PrimeNoExoDto.getDateAffectationP());
		prime.setEmployePrime(EmployeDto.toEntity(PrimeNoExoDto.getEmployePrime()));
		return prime;
	}
}
