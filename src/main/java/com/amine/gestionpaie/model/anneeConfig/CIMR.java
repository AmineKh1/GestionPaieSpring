package com.amine.gestionpaie.model.anneeConfig;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@DiscriminatorValue("CIM")
public class CIMR extends AnneeConfigurable{
	private Double  tauxSalarial;
	private Double tauxPatronale;
	public CIMR(int annees) {
		super(annees);
		// TODO Auto-generated constructor stub
	}
	public CIMR(int annees, Double tauxSalarial, Double tauxPatronale) {
		super(annees);
		this.tauxSalarial = tauxSalarial;
		this.tauxPatronale = tauxPatronale;
	}
	public CIMR() {
		// TODO Auto-generated constructor stub
	}

}
