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
public class Avance extends AbstractEntity{
	@Id @GeneratedValue
	private Long idAvance;
	private Double valeurAvance;
	private Date dateAffectionA;
	@ManyToOne
	private Employe employeAvance;
	private Integer idSociete;

}
