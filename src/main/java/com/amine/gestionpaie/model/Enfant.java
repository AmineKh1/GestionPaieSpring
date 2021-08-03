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
public class Enfant implements Serializable{
	@Id @GeneratedValue
	private Long idEnfant;
	private Date datedeNaissance;
	@ManyToOne
	private Employe employeEnfant;
	private Integer idSociete;


}
