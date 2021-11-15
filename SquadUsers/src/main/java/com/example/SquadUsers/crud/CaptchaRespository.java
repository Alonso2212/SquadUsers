package com.example.SquadUsers.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SquadUsers.objects.Captcha;


@Repository
public interface CaptchaRespository extends CrudRepository<Captcha, Long> {}