package com.example.SquadUsers.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SquadUsers.crud.SettingsRepository;
import com.example.SquadUsers.objects.Settings;

@RestController
public class SettingsController {
	
	@Autowired
	private SettingsRepository settingsRepository;
	String respuesta="Captcha configured! ";
	 
	@GetMapping("/settings")
	public String setSettings(@RequestParam int attempts,int length,int alphanumeric) {
		
		respuesta="Captcha configured! ";
		 
		Settings settings = new Settings();
		settings.setId(1);
		settings.setAlphanumeric(alphanumeric);
		settings.setAttempts(attempts);
		settings.setCaptchaLength(length);
		
		settingsRepository.save(settings);
		
		return  respuesta;
		
		
		
	}

}
