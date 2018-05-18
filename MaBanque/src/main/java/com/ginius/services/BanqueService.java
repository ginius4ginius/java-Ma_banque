package com.ginius.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ginius.dao.CompteRepository;
import com.ginius.dao.OperationRepository;
import com.ginius.entities.Compte;
import com.ginius.entities.CompteCourant;
import com.ginius.entities.Operation;
import com.ginius.entities.Retrait;
import com.ginius.entities.Versement;

@Service
@Transactional
public class BanqueService implements IBanqueService {

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;

	@Override
	public Compte consulterCompte(String codeCompte) {
		Compte cp = compteRepository.findById(codeCompte).get(); // get retourne le compte ou une exception
		return cp;
	}

	@Override
	public void verser(String codeCompte, double montant) {
		Compte cp = consulterCompte(codeCompte);
		Versement v = new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde() + montant);
		compteRepository.save(cp);

	}

	@Override
	public void retirer(String codeCompte, double montant) {
		Compte cp = consulterCompte(codeCompte);
		double faciliteCaisse = 0;
		if (cp instanceof CompteCourant)
			faciliteCaisse = ((CompteCourant) cp).getDecouvert();
		if (cp.getSolde() + faciliteCaisse < montant)
			throw new RuntimeException("solde insuffisant");

		Retrait r = new Retrait(new Date(), montant, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde() + montant);
		compteRepository.save(cp);

	}

	@Override
	public void virement(String codeCompte1, String codeCompte2, double montant) {
		verser(codeCompte1, montant);
		retirer(codeCompte2, montant);

	}

	@Override
	public Page<Operation> listOperations(String codeCompte, int page, int size) {
		
		return operationRepository.listOperations(codeCompte, new PageRequest(page, size));
	}

}
