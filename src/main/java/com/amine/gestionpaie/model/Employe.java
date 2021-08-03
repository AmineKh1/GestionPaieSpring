package com.amine.gestionpaie.model;

import java.io.*;
import java.util.*;
import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
// maybe should be false
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("serial")
@Entity
public class Employe extends AbstractEntity{
	@Id @GeneratedValue
	private Long matricule;
	private String nom;
	private String prenom;
	private String cin;
	@Embedded
	private Adresse adresseE;
	private Date dateNaissance;
	private String sexe;
	private Boolean situationFamiliale;
	private String email;
	private String tel;
	private int compteBancaire;
	private int numCnss;
	private int numMutulle;
	
	private String photo;
	@ManyToOne
	private Banque banque;
	@ManyToOne
	private Societe societe;
	@ManyToOne
	private Departement departement;
	@OneToMany(mappedBy="employeContrat",fetch=FetchType.LAZY)
	private Collection<Contrat> contrats;
	@ManyToMany
    @JoinTable( name = "Employe_diplomes_Associations",
                joinColumns = @JoinColumn( name = "idemploye" ),
                inverseJoinColumns = @JoinColumn( name = "iddiplome" ) )
	private Collection<Diplome> diplomes;
	@OneToMany(mappedBy="employeCredit",fetch=FetchType.LAZY)
	private Collection<Credit> credits;
	@OneToMany(mappedBy="employePrime",fetch=FetchType.LAZY)
	private Collection<PrimeNormal> primes;
	@OneToMany(mappedBy="employeConge",fetch=FetchType.LAZY)
	private Collection<Conge> conges;
	@OneToMany(mappedBy="employeAvance",fetch=FetchType.LAZY)
	private Collection<Avance> avances;
	@OneToMany(mappedBy="employePret",fetch=FetchType.LAZY)
	private Collection<Pret> prets;
	@OneToMany(mappedBy="employeBulletinpaie",fetch=FetchType.LAZY)
	private Collection<BulletinPaie> bulletinpaies;
	@OneToMany(mappedBy="employeEnfant",fetch=FetchType.LAZY)
	private Collection<Enfant> enfants;


}
