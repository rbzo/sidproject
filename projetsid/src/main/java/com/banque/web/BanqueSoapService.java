/*package com.banque.web;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banque.dao.entities.Client;
import com.banque.dao.entities.Compte;
import com.banque.dao.entities.Employe;
import com.banque.dao.entities.Groupe;
import com.banque.dao.entities.Operation;
import com.banque.dao.repositories.CompteRepository;
import com.banque.dao.repositories.OperationRepository;
import com.banque.metier.IbanqueMetier;

@Component
@WebService
@RequestMapping("/banque")
public class BanqueSoapService {
	@Autowired
	private IbanqueMetier banquemetier;
    @WebMethod
	public Groupe addGroup(Groupe g) {
		return banquemetier.addGroup(g);
	}
    @WebMethod
	public Employe addEmploye(Employe e) {
		return banquemetier.addEmploye(e);
	}
    @WebMethod
	public void addEmployeToGroup(@WebParam Long codeEmploye, @WebParam Long codeGroupe) {
		banquemetier.addEmployeToGroup(codeEmploye, codeGroupe);
	}
    @WebMethod
	public Client addClient(Client c) {
		return banquemetier.addClient(c);
	}
    @WebMethod
	public Compte addCompte(Compte c) {
		return banquemetier.addCompte(c);
	}
    @WebMethod
	public void versement(@WebParam String numCompte,@WebParam double mt, @WebParam Long CodeEmploye) {
		banquemetier.versement(numCompte, mt, CodeEmploye);
	}
    @WebMethod
	public void retrait(@WebParam String numCompte, @WebParam double mt, @WebParam Long CodeEmploye) {
		banquemetier.retrait(numCompte, mt, CodeEmploye);
	}
    @WebMethod
	public void virement(@WebParam double mt, @WebParam String numcompte1, @WebParam String numcompte2,
			Long codeEmploye) {
		banquemetier.virement(mt, numcompte1, numcompte2, codeEmploye);
	}
    @WebMethod
	public Compte consulterCompte(@WebParam String codeCompte) {
		return banquemetier.consulterCompte(codeCompte);
	}
    @WebMethod
	public List<Compte> getComptesByClient(@WebParam Long codeClient) {
		return banquemetier.getComptesByClient(codeClient);
	}
    @WebMethod
	public Operation addOperation(Operation op, @WebParam Long codeEmploye,
			@WebParam String codeCompte) {
		return banquemetier.addOperation(op, codeEmploye, codeCompte);
	}

	public Page<Operation> consulterOperations(String codeCompte, int page) {
		return banquemetier.consulterOperations(codeCompte, page);
	}

	public List<Compte> getallcomptes() {
		return banquemetier.getallcomptes();
	}
	
	

}
*/