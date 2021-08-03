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
@DiscriminatorValue("MUT")
public class Mutuelle extends AnneeConfigurable{
	private double tauxSalarialM;
	private double tauxPatronalM;
	public Mutuelle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mutuelle(int annees, double tauxSalarialM, double tauxPatronalM) {
		super(annees);
		this.tauxSalarialM = tauxSalarialM;
		this.tauxPatronalM = tauxPatronalM;
	}
	public double getTauxSalarialM() {
		return tauxSalarialM;
	}
	public void setTauxSalarialM(double tauxSalarialM) {
		this.tauxSalarialM = tauxSalarialM;
	}
	public double getTauxPatronalM() {
		return tauxPatronalM;
	}
	public void setTauxPatronalM(double tauxPatronalM) {
		this.tauxPatronalM = tauxPatronalM;
	}

}
