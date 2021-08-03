package com.amine.gestionpaie.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//maybe should be false
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("serial")
@Entity
public class PrimeCourant extends Prime{
	@OneToMany(mappedBy="CollectionPrime",fetch=FetchType.LAZY)
	private Collection<PrimeCourantList> primeCourantList;
	
}
