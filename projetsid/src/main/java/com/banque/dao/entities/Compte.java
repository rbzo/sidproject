package com.banque.dao.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE", discriminatorType=DiscriminatorType.STRING)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
	@Type(name="CC", value=CompteCourant.class),
	@Type(name="CE", value=CompteEpargne.class)
})
@XmlSeeAlso({CompteCourant.class, CompteEpargne.class})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="numCompte")
public class Compte implements Serializable {
	@Id
	private String numCompte;
	private Date dateCreation;
	private double solde;
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;
	
	@ManyToOne
	@JoinColumn(name="ID_EMPLOYE")
	private Employe employe;
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(String numCompte, Date dateCreation, double solde) {
		super();
		this.numCompte = numCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}
	public String getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Compte(Date dateCreation, double solde) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
	}
	public Compte(String numCompte, Date dateCreation, double solde,
			Client client, Collection<Operation> operations, Employe employe) {
		super();
		this.numCompte = numCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
		this.operations = operations;
		this.employe = employe;
	}
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
	
	
	
	
	
	

}
