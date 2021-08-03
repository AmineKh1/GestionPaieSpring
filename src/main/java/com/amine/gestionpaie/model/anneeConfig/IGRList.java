package com.amine.gestionpaie.model.anneeConfig;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



import lombok.Builder;
import lombok.Data;
@SuppressWarnings("serial")
@Data

@Entity
public class IGRList implements Serializable{
	@Id @GeneratedValue
	private Long idtaxI;
	private Double debutTrancheIGR;
	private Double finTrancheIGR;
	private double tauxIGR;
	Double valeurIGR;
	@ManyToOne
	private IGR igr;
	public IGRList() {
		super();
		// TODO Auto-generated constructor stub
	};
	
	public IGRList(Double debutTrancheIGR, Double finTrancheIGR, double tauxIGR,Double valeurIGR, IGR igr) {
		super();
		this.debutTrancheIGR = debutTrancheIGR;
		this.finTrancheIGR = finTrancheIGR;
		this.tauxIGR = tauxIGR;
		this.valeurIGR=valeurIGR;
		this.igr = igr;
	}


}
