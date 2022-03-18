package ru.javarush.sheff.cryptoanalyzer.utils;

import java.util.HashMap;

public class CorrectEncryptionTableMapGenerator {
    private static CorrectEncryptionTableMapGenerator INSTANCE;
    private static HashMap<String, String> correctEncryptionTableMap;

    private CorrectEncryptionTableMapGenerator() {
    }

    public static CorrectEncryptionTableMapGenerator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CorrectEncryptionTableMapGenerator();
        }
        return INSTANCE;
    }

    public HashMap<String, String> getMap() {
        return correctEncryptionTableMap;
    }

    public void putSymbolsToMap(String correctSymbols) {
        correctEncryptionTableMap = new HashMap<>();

        if (correctSymbols == null) {
            correctEncryptionTableMap = new HashMap<>();
        } else {
            char[] chars = correctSymbols.toCharArray();
            for (int i = 0; i < chars.length; i += 2) {
                correctEncryptionTableMap.put(Character.toString(chars[i]), Character.toString(chars[i + 1]));
            }
        }
    }
}
