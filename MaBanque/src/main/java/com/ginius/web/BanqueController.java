package com.ginius.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ginius.entities.Compte;
import com.ginius.entities.Operation;
import com.ginius.services.IBanqueService;

@Controller
public class BanqueController {
	
	@Autowired
	private IBanqueService banqueService;
	
	/**
	 * retourne a la page de la consultation d'un compte sans paramètres
	 * @return
	 */
	@RequestMapping("/operations")
	public String index() {
		return "comptes";
	}
	
	/**
	 * méthode qui permet d'afficher les données d'un compte depuis la page comptes
	 * @param model
	 * @param codeCompte
	 * @param p
	 * @return
	 */
	@RequestMapping("/consulterCompte")
	public String consulter(Model model, String codeCompte, @RequestParam(name = "page", defaultValue = "0") int p) {
		model.addAttribute("codeCompte",codeCompte);
		try {
			Compte cpt = banqueService.consulterCompte(codeCompte);
			Page<Operation> pageOperations = banqueService.listOperations(codeCompte, p, 4);
			
			model.addAttribute("compte",cpt);
			//insersion dans le model de la liste des opération et des données pour la pagination
			model.addAttribute("listeOperations",pageOperations.getContent());
			int[] pages = new int[pageOperations.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("size", 4);
			model.addAttribute("pageCourante", p);
			
		} catch (Exception e) {
			model.addAttribute("exception",e.getMessage());
		}
		return "comptes";
	}
}
