package com.banque.dao.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;
@Entity
@DiscriminatorValue(value="CC")
@XmlType(name="CC")
public class CompteCourant extends Compte implements Serializable {
	private double decouvert;

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(String numCompte, Date dateCreation, double solde,
			double decouvert) {
		super(numCompte, dateCreation, solde);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public CompteCourant(Date dateCreation, double solde, double decouvert) {
		super(dateCreation, solde);
		this.decouvert = decouvert;
	}

	public CompteCourant(Date dateCreation, double solde) {
		super(dateCreation, solde);
		// TODO Auto-generated constructor stub
	}

	
	
	

}
