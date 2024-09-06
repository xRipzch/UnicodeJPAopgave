package com.example.jpaopgave.ConfigureData;

import com.example.jpaopgave.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitMisc implements CommandLineRunner {
    @Autowired
    private CharacterService characterService;

    @Override
    public void run(String... args) throws Exception {
        characterService.saveUnicodeToDB();
    }
}