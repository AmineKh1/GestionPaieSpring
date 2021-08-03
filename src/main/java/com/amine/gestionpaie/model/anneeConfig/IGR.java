package com.amine.gestionpaie.model.anneeConfig;

import java.io.*;
import java.util.*;
import javax.persistence.*;

import com.amine.gestionpaie.model.Employe;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@DiscriminatorValue("IGR")
public class IGR extends AnneeConfigurable{
	private Double fraisFamille;
	@OneToMany(mappedBy="igr",fetch=FetchType.LAZY)
	private Collection<IGRList> igrList;
	public IGR() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IGR(int annees, Collection<IGRList> igrList,Double fraisFamille) {
		super(annees);
		this.igrList = igrList;
		this.fraisFamille=fraisFamille;
	}
	public IGR(int annees) {
		super(annees);
		// TODO Auto-generated constructor stub
	}
	

	
	


}
