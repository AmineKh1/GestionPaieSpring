package com.amine.gestionpaie.dto;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import com.amine.gestionpaie.model.Prime;
import com.amine.gestionpaie.model.PrimeCourant;
import com.amine.gestionpaie.model.PrimeCourantList;
import com.amine.gestionpaie.model.PrimeNormal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrimeCourantDto {
	private Long idPrime;
	private String nomPrime;
	private String code;
	private Double valeurPrime;
	
	private Collection<PrimeCourantListDto> primeCourantList;
	private EmployeDto employePrime;
	public static PrimeCourantDto fromEntity(PrimeCourant prime) {
		if(prime == null) {
			return null;
			
		}
		return PrimeCourantDto.builder()
				.idPrime(prime.getIdPrime())
				.nomPrime(prime.getNomPrime())
				.code(prime.getCode())
				.valeurPrime(prime.getValeurPrime())
				.primeCourantList(
						prime.getPrimeCourantList()!=null?
								prime.getPrimeCourantList().stream()
									.map(PrimeCourantListDto::fromEntity)
									.collect(Collectors.toList()) : null)
			           
				.employePrime(EmployeDto.fromEntity(prime.getEmployePrime()))
				.build();
	}
	public static PrimeCourant toEntity(PrimeCourantDto primeDto) {
		if(primeDto == null) {
			return null;
		}
		PrimeCourant prime = new PrimeCourant();
		prime.setIdPrime(primeDto.getIdPrime());
		prime.setNomPrime(primeDto.getNomPrime());
		prime.setCode(primeDto.getCode());
		prime.setValeurPrime(primeDto.getValeurPrime());
		prime.setEmployePrime(EmployeDto.toEntity(primeDto.getEmployePrime()));
		return prime;
	}

}
