package com.amine.gestionpaie.model.anneeConfig;

import java.io.*;
import java.util.*;
import javax.persistence.*;

import com.amine.gestionpaie.model.Employe;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@DiscriminatorValue("AMO")
public class AMO extends AnneeConfigurable{
	private double tauxAmoSalarial;
	private double tauxAmoPatronale;
	private double tauxPartipation;
	public AMO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AMO(int annees, double tauxAmoSalarial, double tauxAmoPatronale, double tauxPartipation) {
		super(annees);
		this.tauxAmoSalarial = tauxAmoSalarial;
		this.tauxAmoPatronale = tauxAmoPatronale;
		this.tauxPartipation = tauxPartipation;
	}
	public double getTauxAmoSalarial() {
		return tauxAmoSalarial;
	}
	public void setTauxAmoSalarial(double tauxAmoSalarial) {
		this.tauxAmoSalarial = tauxAmoSalarial;
	}
	public double getTauxAmoPatronale() {
		return tauxAmoPatronale;
	}
	public void setTauxAmoPatronale(double tauxAmoPatronale) {
		this.tauxAmoPatronale = tauxAmoPatronale;
	}
	public double getTauxPartipation() {
		return tauxPartipation;
	}
	public void setTauxPartipation(double tauxPartipation) {
		this.tauxPartipation = tauxPartipation;
	}

}
