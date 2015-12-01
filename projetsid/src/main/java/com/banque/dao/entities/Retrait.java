package com.banque.dao.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value="RTR")
public class Retrait extends Operation implements Serializable {

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Long numOperation, String dateOperation, double montant) {
		super(numOperation, dateOperation, montant);
		// TODO Auto-generated constructor stub
	}

	public Retrait(String dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}
	
	

}
