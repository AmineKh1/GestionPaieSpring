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
@DiscriminatorValue("CNS")
public class CNSS extends AnneeConfigurable{
	private double  tauxSalarialSP;
	private double plafondSalarialSP;
	private double tauxPatronaleSP;
	private double taxPatronalAF;
	private double tauxPatronalFP;
	public CNSS() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CNSS(int annees, double tauxSalarialSP, double plafondSalarialSP, double tauxPatronaleSP,
			double taxPatronalAF, double tauxPatronalFP) {
		super(annees);
		this.tauxSalarialSP = tauxSalarialSP;
		this.plafondSalarialSP = plafondSalarialSP;
		this.tauxPatronaleSP = tauxPatronaleSP;
		this.taxPatronalAF = taxPatronalAF;
		this.tauxPatronalFP = tauxPatronalFP;
	}
	public double getTauxSalarialSP() {
		return tauxSalarialSP;
	}
	public void setTauxSalarialSP(double tauxSalarialSP) {
		this.tauxSalarialSP = tauxSalarialSP;
	}
	public double getPlafondSalarialSP() {
		return plafondSalarialSP;
	}
	public void setPlafondSalarialSP(double plafondSalarialSP) {
		this.plafondSalarialSP = plafondSalarialSP;
	}
	public double getTauxPatronaleSP() {
		return tauxPatronaleSP;
	}
	public void setTauxPatronaleSP(double tauxPatronaleSP) {
		this.tauxPatronaleSP = tauxPatronaleSP;
	}
	public double getTaxPatronalAF() {
		return taxPatronalAF;
	}
	public void setTaxPatronalAF(double taxPatronalAF) {
		this.taxPatronalAF = taxPatronalAF;
	}
	public double getTauxPatronalFP() {
		return tauxPatronalFP;
	}
	public void setTauxPatronalFP(double tauxPatronalFP) {
		this.tauxPatronalFP = tauxPatronalFP;
	}

}
