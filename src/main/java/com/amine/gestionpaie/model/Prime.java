package com.amine.gestionpaie.model;

import java.io.*;
import java.time.Instant;
import java.util.*;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Prime extends AbstractEntity{
	@Id @GeneratedValue
	private Long idPrime;
	private String nomPrime;
	private String code;
	private Double valeurPrime;
	@ManyToOne
	private Employe employePrime;

}

