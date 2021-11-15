package com.example.SquadUsers.controllers;

import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.SquadUsers.crud.CaptchaRespository;
import com.example.SquadUsers.crud.SettingsRepository;
import com.example.SquadUsers.objects.Captcha;
import com.example.SquadUsers.objects.CheckCaptcha;
import com.example.SquadUsers.objects.Settings;

@Controller
public class SetCaptchaController {
	
	@Autowired
	private CaptchaRespository captchaRespository;
	@Autowired
	private SettingsRepository settingsRepository; 
	
	
	
	@GetMapping("/setCaptcha")
	public String setCaptcha(Model model) {
		Optional<Settings> settingsStored= settingsRepository.findById( (long) 1);
		Settings settings = new Settings();
		if (!settingsStored.isEmpty()) {
			settings = settingsStored.get();			
		}else {
			settings.setId(1);
			settings.setAttempts(3);
			settings.setAlphanumeric(0);
			settings.setCaptchaLength(8);
			settingsRepository.save(settings);
		}
		
	String captchaString="";	
		if(settings.getAlphanumeric()==1) {
			captchaString=generateAlphaNumeric(settings.getCaptchaLength());
		}else {
			captchaString=generateNumneric(settings.getCaptchaLength());
		}
		
		Captcha captcha = new Captcha();
		CheckCaptcha checkCaptcha= new CheckCaptcha();
		captcha.setId(2);
		captcha.setCaptcha(captchaString);	
		captcha.setAttempts(0);
		captchaRespository.save(captcha);
		model.addAttribute("captcha", captchaString);
		model.addAttribute(checkCaptcha);
		
		
		
		return "captcha";
		
	}
	
	
	private String generateAlphaNumeric(int length) {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = length;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    System.out.println(generatedString);
	    return generatedString;
	}
	private String generateNumneric(int length) {
		
		        int min = (int) Math.pow(10, length - 1);
		        int max = (int) Math.pow(10, length); // bound is exclusive

		        Random random = new Random();

		        return Integer.toString(random.nextInt(max - min) + min);

	}
	
	
}
