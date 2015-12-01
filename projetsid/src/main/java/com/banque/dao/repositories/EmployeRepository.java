package com.banque.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banque.dao.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long>{

}
