package com.amine.gestionpaie.model.anneeConfig;
 
import java.io.*;
import java.util.*;
import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
@SuppressWarnings("serial")
@Data

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="Annee_Tax",discriminatorType=DiscriminatorType.STRING,length=3)
public abstract class AnneeConfigurable implements Serializable{
	@Id @GeneratedValue
	private Long idannees;
	private int annees;
	public AnneeConfigurable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnneeConfigurable(int annees) {
		super();
		this.annees = annees;
	}


}
