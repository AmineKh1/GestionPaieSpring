package com.amine.gestionpaie.model.anneeConfig;

import java.io.*;
import java.util.*;
import javax.persistence.*;

import com.amine.gestionpaie.model.Employe;
import com.amine.gestionpaie.model.Enfant;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@DiscriminatorValue("ANC")
public class Anciennete extends AnneeConfigurable{
	
	
	@OneToMany(mappedBy="anciennete",fetch=FetchType.LAZY)
	private Collection<AncienneteList> ancienneteList;

	public Anciennete() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Anciennete(int annees, Collection<AncienneteList> ancienneteList) {
		super(annees);
		this.ancienneteList = ancienneteList;
	}

	public Collection<AncienneteList> getAncienneteList() {
		return ancienneteList;
	}

	public void setAncienneteList(Collection<AncienneteList> ancienneteList) {
		this.ancienneteList = ancienneteList;
	}

	public Anciennete(int annees) {
		super(annees);
		// TODO Auto-generated constructor stub
	}

	
}
