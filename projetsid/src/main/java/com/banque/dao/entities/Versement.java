package com.banque.dao.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value="VSM")
public class Versement extends Operation implements Serializable{

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Long numOperation, String dateOperation, double montant) {
		super(numOperation, dateOperation, montant);
		// TODO Auto-generated constructor stub
	}

	public Versement(String dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
