package com.banque.dao.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="numGroupe")
public class Groupe implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numGroupe;
	private String nomGroupe;
	
	@ManyToMany(mappedBy="groupes")
	private Collection<Employe> employes;
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Groupe(Long numGroupe, String nomGroupe) {
		super();
		this.numGroupe = numGroupe;
		this.nomGroupe = nomGroupe;
	}
	public Long getNumGroupe() {
		return numGroupe;
	}
	public void setNumGroupe(Long numGroupe) {
		this.numGroupe = numGroupe;
	}
	public String getNomGroupe() {
		return nomGroupe;
	}
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	public Collection<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}
	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}
	
	

}
