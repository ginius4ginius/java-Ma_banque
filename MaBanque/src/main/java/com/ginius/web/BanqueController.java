package com.ginius.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ginius.services.IBanqueService;

@Controller
public class BanqueController {
	
	@Autowired
	private IBanqueService banqueService;

	@RequestMapping("/operations")
	public String index() {
		return "comptes";
	}
}
