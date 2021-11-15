package com.example.SquadUsers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.SquadUsers.objects.Settings;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index( Model model, Settings settings) {
				
		return "index";
	}

	}
	

