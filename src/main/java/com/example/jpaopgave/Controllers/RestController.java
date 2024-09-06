package com.example.jpaopgave.Controllers;

import com.example.jpaopgave.model.Uni;
import com.example.jpaopgave.Repositories.UnicodeRepository;
import com.example.jpaopgave.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private UnicodeRepository unicodeRepository;

    @Autowired
    private CharacterService characterService;

    @GetMapping("/unicode/{i}")
    public String unicodeToChar(@PathVariable int i) {
        char c = (char) i;
        return "unicode=" + i + " char=" + c;
    }

    @GetMapping("/char/{c}")
    public String charToUnicode(@PathVariable String c) {
        if (c.length() != 1) {
            throw new IllegalArgumentException("Input must be a single character");
        }
        char character = c.charAt(0);
        int unicode = (int) character;
        return "char=" + character + " unicode=" + unicode;
    }
//Loader langsomt.
    @GetMapping("/unicodes")
    public List<Uni> getUnicodes() {
        return unicodeRepository.findAll();
    }

    @GetMapping("/unicode/{c}/{i}")
    public List<Character> getCharactersByAmount(@PathVariable char c, @PathVariable int i) {
        return characterService.getCharactersByAmount(c, i);
    }
}