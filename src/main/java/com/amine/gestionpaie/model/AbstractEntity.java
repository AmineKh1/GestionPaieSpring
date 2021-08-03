package com.amine.gestionpaie.model;

import java.io.*;
import java.time.Instant;
import java.util.*;
import javax.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@SuppressWarnings("serial")
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable{
	
	@CreatedDate
	@Column(name="creationDate", nullable = false, updatable=false )
	@JsonIgnore
	private Date creationDate;
	@LastModifiedDate
	@Column(name="LastModifiedDate")
	@JsonIgnore
	private Instant lastUpdateDate;
	

}
 