package ru.javarush.sheff.cryptoanalyzer.utils;

import ru.javarush.sheff.cryptoanalyzer.exceptions.AppException;

import java.io.*;
import java.util.HashMap;

public class SymbolsFrequencyMapGenerator {

    HashMap<Character, Integer> symbolsFrequencyMap = new HashMap<>();
    char[] alphabet;

    public HashMap<Character, Integer> getSymbolsFrequencyMap(String representative) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(representative))) {
            char representativeChar;
            int count;
            int symbol = bufferedReader.read();
            while (symbol != -1) {  // When it reaches the end of the file, it will get '-1'
                representativeChar = (char) symbol; // Converted to char
                if (symbolsFrequencyMap.containsKey(representativeChar)) {
                    count = symbolsFrequencyMap.get(representativeChar);
                    symbolsFrequencyMap.put(representativeChar, ++count);
                } else {
                    symbolsFrequencyMap.put(representativeChar, 1);
                }
                symbol = bufferedReader.read(); // Reading a symbol
            }
        } catch (IOException e) {
            throw new AppException(e);
        }
        for (HashMap.Entry<Character, Integer> alphabet : symbolsFrequencyMap.entrySet()) {
            System.out.println(alphabet.getKey() + " - " + alphabet.getValue());
        }
        return null;
    }
}
