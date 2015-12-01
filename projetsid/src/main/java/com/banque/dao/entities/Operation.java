package com.banque.dao.entities;

import java.sql.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OPERATION", discriminatorType=DiscriminatorType.STRING)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="TYPE")
@JsonSubTypes({
	@Type(name="V", value=Versement.class),
	@Type(name="R", value=Retrait.class)
})
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="numOperation")
public class Operation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long numOperation;
  private String dateOperation;
  private double montant;
  
  @ManyToOne
  @JoinColumn(name="NUM_COMPTE")
  private Compte compte;
  @ManyToOne
  @JoinColumn(name="CODE_EMPLOYE")
  private Employe employe;
  
public Operation() {
	super();
	// TODO Auto-generated constructor stub
}
public Operation(Long numOperation, String dateOperation, double montant) {
	super();
	this.numOperation = numOperation;
	this.dateOperation = dateOperation;
	this.montant = montant;
}
public Long getNumOperation() {
	return numOperation;
}
public void setNumOperation(Long numOperation) {
	this.numOperation = numOperation;
}
public String getDateOperation() {
	return dateOperation;
}
public void setDateOperation(String dateOperation) {
	this.dateOperation = dateOperation;
}
public double getMontant() {
	return montant;
}
public void setMontant(double montant) {
	this.montant = montant;
}
@JsonIgnore
@XmlTransient
public Compte getCompte() {
	return compte;
}
public void setCompte(Compte compte) {
	this.compte = compte;
}
public Employe getEmploye() {
	return employe;
}
public void setEmploye(Employe employe) {
	this.employe = employe;
}
public Operation(String dateOperation, double montant) {
	super();
	this.dateOperation = dateOperation;
	this.montant = montant;
}



  
}
