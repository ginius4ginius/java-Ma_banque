package com.ginius.services;

import org.springframework.data.domain.Page;

import com.ginius.entities.Compte;
import com.ginius.entities.Operation;

public interface IBanqueService {
	
	public Compte consulterCompte(String codeCompte);
	
	public void verser(String codeCompte, double montant);
	
	public void retirer(String codeCompte, double montant);
	
	public void virement(String codeCompte1, String codeCompte2, double montant);
	
	public Page<Operation> listOperations(String codeCompte, int page, int size);

}
