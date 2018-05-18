package com.ginius;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ginius.dao.ClientRepository;
import com.ginius.dao.CompteRepository;
import com.ginius.dao.OperationRepository;
import com.ginius.entities.Client;
import com.ginius.entities.Compte;
import com.ginius.entities.CompteCourant;
import com.ginius.entities.CompteEpargne;
import com.ginius.entities.Retrait;
import com.ginius.entities.Versement;
import com.ginius.services.IBanqueService;

@SpringBootApplication
public class MaBanqueApplication implements CommandLineRunner { //interface pour tester les repository

	@Autowired
	private ClientRepository clientRepository;//instancié pour test 
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueService banqueService;
	
	
	public static void main(String[] args) {
	SpringApplication.run(MaBanqueApplication.class, args);
	
	
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//méthode pour tester l'utilisation d'un repository après sa création
		Client c1 = clientRepository.save(new Client("Derieu","vincent.derieu@outlook.com"));
		Client c2 = clientRepository.save(new Client("Callegari","bouh20@hotmail.com"));
		
		Compte cp1 = compteRepository.save(new CompteCourant("C1", new Date(),8000.,c1,6000.));
		Compte cp2 = compteRepository.save(new CompteEpargne("C2", new Date(),6000.,c2,1.025));
		
		operationRepository.save(new Versement(new Date(),2000,cp1));
		operationRepository.save(new Retrait(new Date(),1500,cp1));	
		operationRepository.save(new Versement(new Date(),2000,cp1));
		operationRepository.save(new Versement(new Date(),1000,cp1));	
		operationRepository.save(new Versement(new Date(),3500,cp1));
		operationRepository.save(new Retrait(new Date(),2000,cp1));	
		
		operationRepository.save(new Versement(new Date(),1500,cp2));
		operationRepository.save(new Retrait(new Date(),500,cp2));	
		operationRepository.save(new Versement(new Date(),1000,cp2));
		operationRepository.save(new Versement(new Date(),2500,cp2));	
		operationRepository.save(new Versement(new Date(),3000,cp2));
		operationRepository.save(new Retrait(new Date(),1500,cp2));	
		
		banqueService.verser(cp1.getCodeCompte(), 11111);
		banqueService.retirer(cp2.getCodeCompte(), 111);
		banqueService.virement(cp1.getCodeCompte(), cp2.getCodeCompte(), 20);
		banqueService.virement(cp1.getCodeCompte(), cp2.getCodeCompte(), 25);
		
		
	}
}
