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
public class Banque extends AbstractEntity{
	@Id @GeneratedValue
	private Long idBanque;
	private String nomBanque;
	@Embedded
	private Adresse adresseB;
	private int fax;
	private String telBanque;
	private String photoB;
	private Integer idSociete;
	@OneToMany(mappedBy="banque",fetch=FetchType.LAZY)
	private Collection<Employe> employes;


}
