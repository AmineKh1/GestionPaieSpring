package com.amine.gestionpaie.model;

import java.io.*;
import java.util.*;
import javax.persistence.*;

import com.amine.gestionpaie.model.utilisateurs.Utilisateur;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)

@Entity
public class Societe extends AbstractEntity {
	@Id @GeneratedValue
	private Long idSociete;
	private String nomSociete;
//	private String formeJuridique;
	@Embedded
	private Adresse adresseS;
	private String telSociete;
	
	private String emailSociete;
	private String siteWeb;
	private Double capitale;
	private String photoS;
	@OneToMany(mappedBy="societe",fetch=FetchType.LAZY)
	private Collection<Departement> departement;
	@OneToMany(mappedBy="societe",fetch=FetchType.LAZY)
	private Collection<Employe> employes;
	@OneToMany(mappedBy = "societe")
	private List<Utilisateur> utilisateurs;



}
