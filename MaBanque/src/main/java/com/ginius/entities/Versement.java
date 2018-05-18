package com.ginius.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {

	/**
	 * 
	 */
	public Versement() {

	}

	/**
	 * @param dateOperation
	 * @param montant
	 * @param compte
	 */
	public Versement(Date dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);
		// TODO Auto-generated constructor stub
	}

}
