package com.amine.gestionpaie.model;

import java.io.*;
import java.util.*;
import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
@SuppressWarnings("serial")
@Data

@Entity
public class Pret extends AbstractEntity{
	@Id @GeneratedValue
	private Long idPret;
	private Double valeurPret;
	private Double retenueMensualle;
	private Date dateAffectationP;
	@ManyToOne
	private Employe employePret;
	private Integer idSociete;
}
