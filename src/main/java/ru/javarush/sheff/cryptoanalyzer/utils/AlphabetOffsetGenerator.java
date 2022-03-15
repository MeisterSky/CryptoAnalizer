package ru.javarush.sheff.cryptoanalyzer.utils;

import ru.javarush.sheff.cryptoanalyzer.constants.Constants;

import java.util.HashMap;

public class AlphabetOffsetGenerator {

    public HashMap<Character, Character> getAlphabetOffsetMap(int offset) {
        char[] alphabet = Constants.ALPHABET;
        HashMap<Character, Character> alphabetOffsetMap = new HashMap<>(alphabet.length);
        if (offset > 0) {
            offset = offset % alphabet.length;
            for (int i = 0; i < alphabet.length; i++) {
                if (i + offset > alphabet.length) {
                    alphabetOffsetMap.put(alphabet[i], alphabet[i - 1 + offset - alphabet.length]);
                } else {
                    alphabetOffsetMap.put(alphabet[i], alphabet[i + offset - 1]);
                }
            }
            return alphabetOffsetMap;
        } else if (offset < 0) {
            offset = -(offset % alphabet.length);
            for (int i = 0; i < alphabet.length; i++) {
                if (i + offset > alphabet.length) {
                    alphabetOffsetMap.put(alphabet[i - 1 + offset - alphabet.length], alphabet[i]);
                } else {
                    alphabetOffsetMap.put(alphabet[i + offset -1], alphabet[i]);
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
