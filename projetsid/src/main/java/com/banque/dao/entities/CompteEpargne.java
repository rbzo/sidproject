package com.banque.dao.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;
@Entity
@DiscriminatorValue(value="CE")
@XmlType(name="CE")
public class CompteEpargne extends Compte implements Serializable{
	private double taux;

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(String numCompte, Date dateCreation, double solde,
			double taux) {
		super(numCompte, dateCreation, solde);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public CompteEpargne(Date dateCreation, double solde, double taux) {
		super(dateCreation, solde);
		this.taux = taux;
	}

	public CompteEpargne(String numCompte, Date dateCreation, double solde,
			Client client, Collection<Operation> operations, Employe employe,
			double taux) {
		super(numCompte, dateCreation, solde, client, operations, employe);
		this.taux = taux;
	}
	
	
	
	

}
