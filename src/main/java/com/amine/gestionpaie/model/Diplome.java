package com.amine.gestionpaie.model;

import java.io.*;
import java.util.*;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
@SuppressWarnings("serial")
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Diplome implements Serializable{
	@Id @GeneratedValue
	private Long idDiplome;
	private String nomDiplome;
	private String typeDiplome;
	private int nvDiplome;
	private Date dateObtenir;
	@ManyToMany
    @JoinTable( name = "Employe_diplomes_Associations",
                joinColumns = @JoinColumn( name = "iddiplome" ),
                inverseJoinColumns = @JoinColumn( name = "idemploye" ) )
	private Collection<Employe> employes;
	private Integer idSociete;

}
