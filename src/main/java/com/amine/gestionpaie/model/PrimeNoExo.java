package com.amine.gestionpaie.model;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//maybe should be false
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("serial")
@Entity
public class PrimeNoExo extends Prime{
	private Date dateAffectationP;

	public PrimeNoExo(Long idPrime, String nomPrime, String code, Double valeurPrime, Employe employePrime) {
		super(idPrime, nomPrime, code, valeurPrime, employePrime);
		// TODO Auto-generated constructor stub
	}

	public PrimeNoExo(Long idPrime, String nomPrime, String code, Double valeurPrime, Employe employePrime,
			Date dateAffectationP) {
		super(idPrime, nomPrime, code, valeurPrime, employePrime);
		this.dateAffectationP = dateAffectationP;
	}

	public PrimeNoExo() {
		super();
	}
	

}
