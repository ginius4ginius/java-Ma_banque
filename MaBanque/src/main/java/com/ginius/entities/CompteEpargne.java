package com.ginius.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {

	private double taux;

	/**
	 * 
	 */
	public CompteEpargne() {
		
	}

	/**
	 * @param codeCompte
	 * @param dateCreation
	 * @param solde
	 * @param client
	 * @param taux
	 */
	public CompteEpargne(String codeCompte, Date dateCreation, Double solde, Client client, double taux) {
		super(codeCompte, dateCreation, solde, client);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
