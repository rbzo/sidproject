package com.banque.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banque.dao.entities.Compte;
import com.banque.dao.entities.Employe;
import com.banque.dao.entities.Groupe;
import com.banque.dao.entities.Operation;
import com.banque.metier.BanqueMetierImpl;
import com.banque.metier.IbanqueMetier;

@RestController
@RequestMapping("/banque")
public class BanqueRestService {
	@Autowired
	private IbanqueMetier metier;
	
	//test
	@RequestMapping("/test")
	@ResponseBody
	private String test(){
		return "hello everybody";
	}
	//ajout de groupe
	@RequestMapping(value="/groupes", method=RequestMethod.POST)
	@ResponseBody
	private Groupe addGroup(@RequestBody Groupe g){
		return metier.addGroup(g);
	}
	
	//ajout d'employe
	@RequestMapping(value="/employes", method=RequestMethod.POST)
	@ResponseBody
	private Employe addEmp(@RequestBody Employe e){
		return metier.addEmploye(e);
	}
	
	//affecter un employe à un groupe
	@RequestMapping(value="/employes/groupes", method=RequestMethod.POST)
	@ResponseBody
    private void addemptogroup(Long codeEmp, long codeGroup)	{
		 metier.addEmployeToGroup(codeEmp, codeGroup);
	}
	
	//ajout de compte
	@RequestMapping(value="/comptes", method=RequestMethod.POST)
	@ResponseBody
	private Compte addCompte(@RequestBody Compte c){
		return metier.addCompte(c);
	}
	
	//effectuer des versements dans un compte
	@RequestMapping(value="/comptes/versement/{refCompte}", method=RequestMethod.POST)
	@ResponseBody
	private void versement(@PathVariable String numCompte,double mt, Long CodeEmploye){
		metier.versement(numCompte, mt, CodeEmploye);
	}
	//effectuer des retraits dans un compte
		@RequestMapping(value="/comptes/retrait/{refCompte}", method=RequestMethod.POST)
		@ResponseBody
		private void retrait(@PathVariable String numCompte,double mt, Long CodeEmploye){
			metier.retrait(numCompte, mt, CodeEmploye);
		}
		
	    
		//effectuer des virements
		
		@RequestMapping(value="/comptes/", method=RequestMethod.POST)
		@ResponseBody
		private void virement(double mt, String numCompte1,String numCompte2,Long CodeEmploye){
			metier.virement(mt, numCompte1, numCompte2, CodeEmploye);
		}
		
		//consulter un compte
		@RequestMapping("/comptes/{refCompte}")
		@ResponseBody
		private Compte getCompte(@PathVariable String refCompte){
			return metier.consulterCompte(refCompte);
		}
		
		//consulter les comptes d'un client
		@RequestMapping("/comptes/clients/{refClient}")
		@ResponseBody
		private List<Compte> getCompteByClient(@PathVariable Long refClient){
			return metier.getComptesByClient(refClient);
		}
		
		//consulter les operations d'un compte
		@RequestMapping("/comptes/{refCompte}/operations")
		@ResponseBody
		private Page<Operation> consulterOperationsByCompte(@PathVariable String refCompte, int page){
			return metier.consulterOperations(refCompte, page);
			
		}
	
	
	   @RequestMapping("/comptes")
	   @ResponseBody
	   public List<Compte> allcomptes(){
		   return metier.getallcomptes();
	   }

}
