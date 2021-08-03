package com.amine.gestionpaie;


import java.util.Date;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.amine.gestionpaie.model.Employe;
@SpringBootApplication
@EnableJpaAuditing

public class GestionpaieApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GestionpaieApplication.class, args);
	    
	}



}
