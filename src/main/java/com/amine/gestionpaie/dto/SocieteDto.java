package com.amine.gestionpaie.dto;

import java.util.Collection;
import java.util.List;

import com.amine.gestionpaie.model.Departement;
import com.amine.gestionpaie.model.Employe;
import com.amine.gestionpaie.model.Societe;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SocieteDto {
	private Long idSociete;
	private String nomSociete;
	private AdresseDto adresseS;
	private String telSociete;
	private String emailSociete;
	private String siteWeb;
	private Double capitale;
	private String photoS;
	@JsonIgnore
	private Collection<EmployeDto> employes;
	@JsonIgnore
	private Collection<DepartementDto> departement;
	@JsonIgnore
	private List<UtilisateurDto> utilisateurs;

	public static SocieteDto fromEntity(Societe societe) {
		if(societe == null ) {
			return null;
		}
		return SocieteDto.builder()
				.idSociete(societe.getIdSociete())
				.nomSociete(societe.getNomSociete())
 				.adresseS(AdresseDto.fromEntity(societe.getAdresseS()))
 				.telSociete(societe.getTelSociete())
 				.emailSociete(societe.getEmailSociete())
 				.siteWeb(societe.getSiteWeb())
 				.capitale(societe.getCapitale())
 				.photoS(societe.getPhotoS())
 				.build();

	}
	public static Societe toEntity(SocieteDto societeDto) {
		if(societeDto == null) {
			return null;
		}
		Societe societe = new Societe();
		societe.setIdSociete(societeDto.getIdSociete());
		societe.setNomSociete(societeDto.getNomSociete());
		societe.setAdresseS(AdresseDto.toEntity(societeDto.getAdresseS()));
		societe.setTelSociete(societeDto.getTelSociete());
		societe.setEmailSociete(societe.getEmailSociete());
		societe.setSiteWeb(societeDto.getSiteWeb());
		societe.setCapitale(societeDto.getCapitale());
		societe.setPhotoS(societeDto.getPhotoS());
		return societe;
	}

}
