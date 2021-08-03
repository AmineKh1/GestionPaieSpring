package com.amine.gestionpaie.model;

import java.io.*;
import java.util.*;
import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
@SuppressWarnings("serial")
@Data

@Entity
public class Conge implements Serializable{
	@Id @GeneratedValue
	private Long idConge;
	private int dureeConge;
	private Date dateDebut;
	private Date dateFin;

	private String type;
	@ManyToOne
	private Employe employeConge;
	private Integer idSociete;
}
