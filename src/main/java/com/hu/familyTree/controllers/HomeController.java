package com.hu.familyTree.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {
	
	
	@GetMapping("/homePage")
	public String showFamilyMembers() {
		return "homePage";
	}

}
