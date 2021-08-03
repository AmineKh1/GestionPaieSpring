package com.amine.gestionpaie.model.anneeConfig;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@DiscriminatorValue("SMC")
public class Smic extends AnneeConfigurable{
	private Double valeurSmig;

	public Smic(int annees) {
		super(annees);
		// TODO Auto-generated constructor stub
	}

	public Smic(int annees, Double valeurSmig) {
		super(annees);
		this.valeurSmig = valeurSmig;
	}

	public Smic() {
		super();
	}



}
