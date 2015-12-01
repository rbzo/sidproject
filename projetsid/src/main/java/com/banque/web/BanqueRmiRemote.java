package com.banque.web;

import java.rmi.Remote;
import java.util.List;

import com.banque.dao.entities.Compte;

public interface  BanqueRmiRemote  extends Remote{
	public Compte addCompte(Compte c);
	public List<Compte> getallcomptes();


}
