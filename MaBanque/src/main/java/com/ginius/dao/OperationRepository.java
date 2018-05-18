package com.ginius.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ginius.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
	
	@Query("SELECT o FROM Operation o WHERE o.compte.codeCompte = :x order by o.dateOperation DESC")
	//requete HQL
	public Page<Operation> listOperations(@Param("x")String codeCompte,Pageable pageable);

}
