package com.example.SquadUsers.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SquadUsers.objects.Settings;

@Repository
public interface SettingsRepository extends CrudRepository<Settings, Long> {}