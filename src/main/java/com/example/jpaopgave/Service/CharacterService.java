package com.example.jpaopgave.Service;

import com.example.jpaopgave.Repositories.UnicodeRepository;
import com.example.jpaopgave.model.Uni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CharacterService {
    @Autowired
    private UnicodeRepository unicodeRepository;
    public List<Character> getCharactersByAmount(char c, int i) {
        List<Character> characterList = new ArrayList<>();
        for (int n = 0; n < i; n++) {
            characterList.add(c);
        }
        return characterList;
    }


    //// Saver ALLE Unicodes til DB - Headsup - tager langtid.
    public void saveUnicodeToDB() {
        Set<Character> characterSet = new HashSet<>();
        int n = 0;
        char charValue;

        while (n <= Character.MAX_VALUE) {
            charValue = (char) n;
            if (!characterSet.add(charValue)) {
                break; // Break the loop if the character is already in the set
            }

            Uni unicode = new Uni();
            unicode.setUnicode((int) charValue);
            unicode.setCharValue(charValue);
            unicode.setName("Name for " + charValue);
            unicode.setDescription("Description for " + charValue);

            unicodeRepository.save(unicode);
            n++;
        }
    }

    private String checkCharType(Character c) {
        String charType;
        if (Character.isLetter(c)) {
            charType = "Letter";
        } else if (Character.isDigit(c)) {
            charType = "Digit";
        } else {
            charType = null;
        }
        return charType;
    }
}