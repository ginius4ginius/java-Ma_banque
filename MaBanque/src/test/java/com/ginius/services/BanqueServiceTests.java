package com.ginius.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BanqueServiceTests implements ABanqueServiceTests {

	@Autowired
	private BanqueService banque;

	public BanqueServiceTests() {
	}

	@Override
	public void contextLoad() {
		// TODO Auto-generated method stub

	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		banque = new BanqueService();
	}

	@After
	public void tearDown() {
	}

	/**
	 * vérifier la fonctionnalité de la classe test
	 */
	@Test
	public void doNothing() {
		// assertFalse(true);//doit retourner une erreur
		assertFalse(false);// doit valider le test
	}

	/**
	 * vérifier l'injection de dépendance de l'objet BanqueService
	 */
	// @ExpectedDatabase("/expectedData.xml")
	@Test
	public void initOk() {
		assertNotNull(banque);
	}

}
