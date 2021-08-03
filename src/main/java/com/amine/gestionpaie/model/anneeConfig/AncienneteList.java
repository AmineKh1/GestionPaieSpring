package com.amine.gestionpaie.model.anneeConfig;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.amine.gestionpaie.dto.AncienneteDto;
import com.amine.gestionpaie.model.Employe;

import lombok.Builder;
import lombok.Data;
@SuppressWarnings("serial")
@Data

@Entity
public class AncienneteList implements Serializable{
	@Id @GeneratedValue
	private Long idtax;
	private int debutTrancheAn;
	private int finTrancheAn;
	private double tauxAnc;
	@ManyToOne
	private Anciennete anciennete;
	
	public AncienneteList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AncienneteList(int debutTrancheAn, int finTrancheAn, double tauxAnc, Anciennete anciennete) {
		super();
		this.debutTrancheAn = debutTrancheAn;
		this.finTrancheAn = finTrancheAn;
		this.tauxAnc = tauxAnc;
		this.anciennete = anciennete;
		
	}


	
}
