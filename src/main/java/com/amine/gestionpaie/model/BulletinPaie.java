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
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Association_Bult",discriminatorType=DiscriminatorType.STRING,length=2)
public class BulletinPaie implements Serializable{
	@Id @GeneratedValue
	private Long idBulletin;
	private Date dateSaisie;
	@ManyToOne
	private Employe employeBulletinpaie;
	private Integer idSociete;

}
