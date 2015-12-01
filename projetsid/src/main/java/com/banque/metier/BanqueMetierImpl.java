package com.banque.metier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.banque.dao.entities.Client;
import com.banque.dao.entities.Compte;
import com.banque.dao.entities.Employe;
import com.banque.dao.entities.Groupe;
import com.banque.dao.entities.Operation;
import com.banque.dao.entities.Retrait;
import com.banque.dao.entities.Versement;
import com.banque.dao.repositories.ClientRepository;
import com.banque.dao.repositories.CompteRepository;
import com.banque.dao.repositories.EmployeRepository;
import com.banque.dao.repositories.GroupeRepository;
import com.banque.dao.repositories.OperationRepository;
@Component("metier")
public class BanqueMetierImpl implements IbanqueMetier {
	private ClientRepository clientRepository;
	private CompteRepository compteRepository;
	private EmployeRepository employeRepository;
	private GroupeRepository groupeRepository;
	private OperationRepository operationRepository;
    
    
	@Autowired
	public BanqueMetierImpl(ClientRepository clientRepository,
			CompteRepository compteRepository,
			EmployeRepository employeRepository,
			GroupeRepository groupeRepository,
			OperationRepository operationRepository) {
		super();
		this.clientRepository = clientRepository;
		this.compteRepository = compteRepository;
		this.employeRepository = employeRepository;
		this.groupeRepository = groupeRepository;
		this.operationRepository = operationRepository;
	}

	private static final SimpleDateFormat dateformat=new SimpleDateFormat("dd/mm/yyyy");
	@Override
	public Groupe addGroup(Groupe g) {
		groupeRepository.save(g);
		return g;
	}
	@Override
	public Employe addEmploye(Employe e) {
		 employeRepository.save(e);
		 return e;
	}
	@Override
	public void addEmployeToGroup(Long codeEmploye, Long  codeGroupe) {
		Employe e= employeRepository.findOne(codeEmploye);
		Groupe g=groupeRepository.findOne(codeGroupe);
		g.getEmployes().add(e);
		e.getGroupes().add(g);
		
	}
	@Override
	public Client addClient(Client c) {
		 clientRepository.save(c);
		 return c;
	}
	@Override
	public Compte addCompte(Compte c) {
		compteRepository.save(c);
		return c;
	}
	@Override
	public void versement(String numCompte, double mt, Long CodeEmploye) {
		Compte cpte = compteRepository.findOne(numCompte);
		cpte.setSolde(cpte.getSolde()+mt);
		addOperation(new Versement(dateformat.format(new Date()), mt), CodeEmploye, numCompte);
		
;		
	}
	@Override
	public void retrait(String numCompte, double mt, Long CodeEmploye) {
		Compte cpte = compteRepository.findOne(numCompte);
		cpte.setSolde(cpte.getSolde()-mt);
		addOperation(new Retrait(dateformat.format(new Date()), mt), CodeEmploye, numCompte);
		
	}
	@Override
	public void virement(double mt, String numcompte1, String numcompte2,
			Long codeEmploye) {
		retrait(numcompte1, mt, codeEmploye);
		versement(numcompte2, mt, codeEmploye);
		
	}
	@Override
	public Compte consulterCompte(String codeCompte) {
		return compteRepository.findOne(codeCompte);
	
	}
	@Override
	public List<Compte> getComptesByClient(Long codeClient) {
		return compteRepository.findComptesByClient(codeClient);
	}
	@Override
	public Page<Operation> consulterOperations(String codeCompte, int page) {
		return operationRepository.findOpsByCompte(codeCompte, new PageRequest(page, 5));
	}
	@Override
	public Operation addOperation(Operation op,Long codeEmploye, String codeCompte) {
		Compte cp= consulterCompte(codeCompte);
		Employe emp= employeRepository.findOne(codeEmploye);
		op.setCompte(cp);
		op.setEmploye(emp);
		operationRepository.save(op);
		return op;
	}
	///pour les tests
	public List<Compte> getallcomptes(){
		return compteRepository.findAll();
	}
	
	
}
