package com.example.SquadUsers.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "settings")
public class Settings {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private int captchaLength;
	private int alphanumeric;
	private int attempts;
	
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCaptchaLength() {
		return captchaLength;
	}
	public void setCaptchaLength(int captchaLength) {
		this.captchaLength = captchaLength;
	}
	public int getAlphanumeric() {
		return alphanumeric;
	}
	public void setAlphanumeric(int alphanumeric) {
		this.alphanumeric = alphanumeric;
	}
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	
	
}
