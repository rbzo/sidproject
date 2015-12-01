package com.banque.metier;

import java.util.List;

import org.springframework.data.domain.Page;

import com.banque.dao.entities.Client;
import com.banque.dao.entities.Compte;
import com.banque.dao.entities.Employe;
import com.banque.dao.entities.Groupe;
import com.banque.dao.entities.Operation;

public interface IbanqueMetier {
	public Groupe addGroup(Groupe g);
	public Employe addEmploye(Employe e);
	public void addEmployeToGroup(Long codeEmploye, Long  codeGroupe);
	public Client addClient(Client c);
	public Compte addCompte(Compte c);
	public void versement(String numCompte, double mt, Long CodeEmploye );
	public void retrait(String numCompte, double mt, Long CodeEmploye);
	public void virement(double mt,String numcompte1,String numcompte2,Long codeEmploye);
	public Compte consulterCompte(String codeCompte);
	public List<Compte> getComptesByClient(Long codeClient);
	public Operation addOperation(Operation op,Long codeEmploye, String codeCompte);
	public Page<Operation> consulterOperations(String codeCompte, int page);
	public List<Compte> getallcomptes();

}
