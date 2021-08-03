package com.amine.gestionpaie.dto;

import java.util.Collection;

import com.amine.gestionpaie.model.Adresse;
import com.amine.gestionpaie.model.Banque;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BanqueDto {
	private Long idBanque;
	private String nomBanque;
	private Integer idSociete;
	private AdresseDto adresseB;
	private int fax;
	private String telBanque;
	private String photoB;
	@JsonIgnore
	private Collection<EmployeDto> employes;
	public static BanqueDto fromEntity(Banque banque) {
		if(banque == null) {
			return null;
		}
		return BanqueDto.builder()
				.idBanque(banque.getIdBanque())
				.nomBanque(banque.getNomBanque())
 				.adresseB(AdresseDto.fromEntity(banque.getAdresseB()))
 				.fax(banque.getFax())
 				.telBanque(banque.getTelBanque())
 				.photoB(banque.getPhotoB())
 				.build();

	}
	public static Banque toEntity(BanqueDto banqueDto) {
		if(banqueDto == null) {
			return null;
		}
		Banque banque = new Banque();
		banque.setIdBanque(banqueDto.getIdBanque());
		banque.setNomBanque(banqueDto.getNomBanque());
		banque.setAdresseB(AdresseDto.toEntity(banqueDto.getAdresseB()));
		banque.setFax(banqueDto.getFax());
		banque.setTelBanque(banqueDto.getTelBanque());
		banque.setPhotoB(banqueDto.getPhotoB());
	
		return banque;
	}
	

}
