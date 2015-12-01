package com.banque.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banque.dao.entities.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {

}
