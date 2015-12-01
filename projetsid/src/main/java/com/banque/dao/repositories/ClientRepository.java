package com.banque.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banque.dao.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
