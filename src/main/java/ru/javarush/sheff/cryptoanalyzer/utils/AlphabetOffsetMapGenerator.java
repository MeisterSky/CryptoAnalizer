package ru.javarush.sheff.cryptoanalyzer.utils;

import java.util.HashMap;

public class AlphabetOffsetMapGenerator {

    HashMap<Character, Character> alphabetOffsetMap;
    char[] alphabet;

    public HashMap<Character, Character> getAlphabetOffsetMap(String lang, int key) {
        alphabet = new AlphabetSelector(lang).getAlphabet();
        alphabetOffsetMap = new HashMap<>(alphabet.length);

        //Encryption needs a positive value and decryption needs a negative value
        if (key > 0) {
            key = key % alphabet.length;
            for (int i = 0; i < alphabet.length; i++) {
                if (i + key > alphabet.length) {
                    alphabetOffsetMap.put(alphabet[i], alphabet[i - 1 + key - alphabet.length]);
                } else {
                    alphabetOffsetMap.put(alphabet[i], alphabet[i + key - 1]);
                }
            }
            return alphabetOffsetMap;
        } else if (key < 0) {
            key = -(key % alphabet.length);
            for (int i = 0; i < alphabet.length; i++) {
                if (i + key > alphabet.length) {
                    alphabetOffsetMap.put(alphabet[i - 1 + key - alphabet.length], alphabet[i]);
                } else {
                    alphabetOffsetMap.put(alphabet[i + key - 1], alphabet[i]);
                }
            }
            return alphabetOffsetMap;
        } else {
            for (char c : alphabet) {
                alphabetOffsetMap.put(c, c);
            }
            return alphabetOffsetMap;
        }
    }
}
