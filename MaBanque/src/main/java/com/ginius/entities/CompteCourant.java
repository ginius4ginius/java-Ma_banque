package com.ginius.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {

	private double decouvert;

	/**
	 * 
	 */
	public CompteCourant() {
		
	}

	/**
	 * @param codeCompte
	 * @param dateCreation
	 * @param solde
	 * @param client
	 * @param decouvert
	 */
	public CompteCourant(String codeCompte, Date dateCreation, Double solde, Client client, double decouvert) {
		super(codeCompte, dateCreation, solde, client);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

}
