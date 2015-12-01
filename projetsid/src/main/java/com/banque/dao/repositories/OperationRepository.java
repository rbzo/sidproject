package com.banque.dao.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.banque.dao.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
	@Query("select o from Operation o where o.compte.numCompte=:x")
	public Page<Operation> findOpsByCompte(@Param("x") String numCompte, Pageable p);
}
