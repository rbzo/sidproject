package com.banque.dao.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="codeEmploye")
public class Employe implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeEmploye;
	private String nomEmploye;
	
	@ManyToOne
	@JoinColumn(name="NUM_SUP")
	private Employe superieurHierarchique;
	@ManyToMany
	@JoinTable(name="EMPLOYE_GROUPES", joinColumns=
	@JoinColumn(name="ID_EMPLOYE"), inverseJoinColumns=
	@JoinColumn(name="ID_GROUPE"))
	private Collection<Groupe> groupes;
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employe(Long codeEmploye, String nomEmploye) {
		super();
		this.codeEmploye = codeEmploye;
		this.nomEmploye = nomEmploye;
	}
	public Long getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	public Employe getSuperieurHierarchique() {
		return superieurHierarchique;
	}
	public void setSuperieurHierarchique(Employe superieurHierarchique) {
		this.superieurHierarchique = superieurHierarchique;
	}
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	public Employe(String nomEmploye) {
		super();
		this.nomEmploye = nomEmploye;
	}
	
	

}
