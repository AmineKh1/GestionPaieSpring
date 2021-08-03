package com.amine.gestionpaie.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
@SuppressWarnings("serial")
@Data

@Entity
public class Departement implements Serializable{
	@Id @GeneratedValue
	private Long numDep;
	private String nomDepart;
	private String superviseurDept;
	@ManyToOne
	private Societe societe;
	@OneToMany(mappedBy="departement",fetch=FetchType.LAZY)
	private Collection<Employe> employes;
	

}
