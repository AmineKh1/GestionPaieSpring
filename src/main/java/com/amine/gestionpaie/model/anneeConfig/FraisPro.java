package com.amine.gestionpaie.model.anneeConfig;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@DiscriminatorValue("FRP")
public class FraisPro extends AnneeConfigurable{
	private Double tauxFrais;
	private Double Plafond;
	public FraisPro(int annees) {
		super(annees);
		// TODO Auto-generated constructor stub
	}
	
	public FraisPro(int annees, Double tauxFrais, Double plafond) {
		super(annees);
		this.tauxFrais = tauxFrais;
		Plafond = plafond;
	}

	public FraisPro() {
		super();
	}
	
	

}
