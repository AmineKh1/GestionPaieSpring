package com.amine.gestionpaie.dto;

import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.amine.gestionpaie.model.PrimeCourant;
import com.amine.gestionpaie.model.PrimeCourantList;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class PrimeCourantListDto {
	private Long idPrimeCourantList;
	private Boolean exist;

	private PrimeCourantDto collectionPrimeCourant;
	public static PrimeCourantListDto fromEntity(PrimeCourantList prime) {
		if(prime==null) {
			return null;
		}
		return PrimeCourantListDto.builder()
				.idPrimeCourantList(prime.getIdPrimeCourantList())
				.exist(prime.getExist())
				.build();
	}
	public static PrimeCourantList toEntity(PrimeCourantListDto primeDto) {
		if(primeDto==null) {
			return null;
		
		}
		PrimeCourantList prime= new PrimeCourantList();
		prime.setIdPrimeCourantList(primeDto.getIdPrimeCourantList());
		prime.setExist(primeDto.getExist());
		prime.setCollectionPrimeCourant(PrimeCourantDto.toEntity(primeDto.getCollectionPrimeCourant()));
		return prime;
	}

}
