package com.amine.gestionpaie.model;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;
@Data

@EqualsAndHashCode(callSuper = false)

@Embeddable
public class Adresse {
	private String adresse1;
	private String ville;
	private String codePostale;
	private String pays;
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Adresse(String adresse1, String ville, String codePostale, String pays) {
		super();
		this.adresse1 = adresse1;
		this.ville = ville;
		this.codePostale = codePostale;
		this.pays = pays;
	}
	public String getAdresse1() {
		return adresse1;
	}
	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	

}
