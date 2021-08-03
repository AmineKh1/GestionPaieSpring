package com.amine.gestionpaie.model;

import java.io.*;
import java.util.*;
import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Contrat implements Serializable{
	@Id @GeneratedValue
	private Long idContrat;
	private Date dateEmbauche;
	private Double salaireBase;
	private String typeContrat;
	private String profession;
	@ManyToOne
	private Employe employeContrat;
	private Integer idSociete;

}
