package com.example.SquadUsers.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.SquadUsers.crud.CaptchaRespository;
import com.example.SquadUsers.crud.SettingsRepository;
import com.example.SquadUsers.objects.Captcha;
import com.example.SquadUsers.objects.CheckCaptcha;
import com.example.SquadUsers.objects.Settings;

@Controller
public class CheckCaptchaController {
	
	@Autowired
	private CaptchaRespository captchaRespository;
	@Autowired
	private SettingsRepository settingsRepository; 
	
	
	@GetMapping("/checkCaptcha")
	public String checkCaptcha(@ModelAttribute CheckCaptcha captcha, Model model) {
		Captcha captchaSettings = new Captcha();
		Optional<Captcha> captchaStored= captchaRespository.findById( (long) 2);
		Optional<Settings> settingsStored= settingsRepository.findById( (long) 1);
		captchaSettings=captchaStored.get();
		if(captchaSettings.getAttempts() >= settingsStored.get().getAttempts()) {
			return "attemptsExceeded";
		}
		if(captcha.getCaptcha().contentEquals(captchaSettings.getCaptcha())) {
			return "succes";
		}else {
			captchaSettings.setAttempts(captchaSettings.getAttempts()+ 1);
			captchaRespository.save(captchaSettings);
			model.addAttribute("captcha", captchaSettings.getCaptcha());
			return "error";
		}
		
		
		
	}

}
