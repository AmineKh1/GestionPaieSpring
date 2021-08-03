package com.amine.gestionpaie.model.utilisateurs;

import java.io.*;
import java.util.*;
import javax.persistence.*;

import com.amine.gestionpaie.model.AbstractEntity;
import com.amine.gestionpaie.model.Employe;
import com.amine.gestionpaie.model.Societe;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
@Entity

public class Utilisateur extends AbstractEntity{
	@Id @GeneratedValue
	private Long idUtilisateur;
	private String mdp;
	private String email;

	@OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Roles> roles;


	  @ManyToOne
	  @JoinColumn(name = "idSociete")
	  private Societe societe;

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(Long idUtilisateur, String email, String mdp, Societe societe) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.email = email;
		this.mdp = mdp;

		this.societe=societe;
	}
}
