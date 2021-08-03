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
public class Credit extends AbstractEntity{
	@Id @GeneratedValue
	private Long idCredit;
	private Double ValeurCredit;
	private Double TauxInteret;
	private Date dateAffectation;

	@ManyToOne
	private Employe employeCredit;
	private Integer idSociete;

}
