package com.banque.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.banque.dao.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {
	@Query("select c from Compte c where c.client.code=:x")
	public List<Compte> findComptesByClient(@Param("x") Long codeCli);

}
