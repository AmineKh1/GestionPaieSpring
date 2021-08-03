package com.amine.gestionpaie.dto;

import java.util.Collection;
import java.util.Date;

import com.amine.gestionpaie.model.Adresse;
import com.amine.gestionpaie.model.Banque;
import com.amine.gestionpaie.model.Departement;
import com.amine.gestionpaie.model.Employe;
import com.amine.gestionpaie.model.Societe;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeDto {
	
	
	private Long matricule;
	private String nom;
	private String prenom;
	private String cin;
	
	private AdresseDto adresseE;
	private Date dateNaissance;
	private String sexe;
	private Boolean situationFamiliale;
	private String email;
	private String tel;
	private int compteBancaire;
	private int numCnss;
	private int numMutulle;
	
	private String photo;
	
	private BanqueDto banque;
	
	private SocieteDto societe;
	private DepartementDto departement;
	@JsonIgnore
	private Collection<ContratDto> contrats;
	@JsonIgnore
	private Collection<DiplomeDto> diplomes;
	@JsonIgnore
	private Collection<CreditDto> credits;
	@JsonIgnore
	private Collection<PrimeNormalDto> primes;
	@JsonIgnore
	private Collection<CongeDto> conges;
	@JsonIgnore
	private Collection<AvanceDto> avances;
	@JsonIgnore
	private Collection<PretDto> prets;
	@JsonIgnore
	private Collection<BulletinPaieDto> bulletinpaies;
	@JsonIgnore
 	private Collection<EnfantDto> enfants;
 	
 	public static EmployeDto fromEntity(Employe employe) {
 		if(employe == null) {
 			return null;
 		}
 		return EmployeDto.builder()
 				.matricule(employe.getMatricule())
 				.nom(employe.getNom())
 				.prenom(employe.getPrenom())
 				.cin(employe.getCin())
 				.adresseE(AdresseDto.fromEntity(employe.getAdresseE()))
 				.dateNaissance(employe.getDateNaissance())
 				.sexe(employe.getSexe())
 				.situationFamiliale(employe.getSituationFamiliale())
 				.email(employe.getEmail())
 				.tel(employe.getTel())
 				.compteBancaire(employe.getCompteBancaire())
 				.numCnss(employe.getNumCnss())
 				.numMutulle(employe.getNumMutulle())
 				.photo(employe.getPhoto())
 				.banque(BanqueDto.fromEntity(employe.getBanque()))
 				.societe(SocieteDto.fromEntity(employe.getSociete()))
 				.departement(DepartementDto.fromEntity(employe.getDepartement()))

 				.build();
 	}
 	public static Employe toEntity(EmployeDto employeDto) {
 		if(employeDto == null) {
 			return null;
 		}
 		Employe employe = new Employe();
 		employe.setMatricule(employeDto.getMatricule());
 		employe.setNom(employeDto.getNom());
 		employe.setPrenom(employeDto.getPrenom());
 		employe.setCin(employeDto.getCin());
 		employe.setAdresseE(AdresseDto.toEntity(employeDto.getAdresseE()));
 		employe.setDateNaissance(employeDto.getDateNaissance());
 		employe.setSexe(employe.getSexe());
 		employe.setSituationFamiliale(employe.getSituationFamiliale());
 		employe.setTel(employeDto.getTel());
 		employe.setCompteBancaire(employeDto.getCompteBancaire());
 		employe.setNumCnss(employeDto.getNumCnss());
 		employe.setNumMutulle(employeDto.getNumMutulle());
 		employe.setPhoto(employeDto.getPhoto());
 		employe.setBanque(BanqueDto.toEntity(employeDto.getBanque()));
 		employe.setSociete(SocieteDto.toEntity(employeDto.getSociete()));
 		employe.setDepartement(DepartementDto.toEntity(employeDto.getDepartement()));
 		return employe;
 	}

	
}
