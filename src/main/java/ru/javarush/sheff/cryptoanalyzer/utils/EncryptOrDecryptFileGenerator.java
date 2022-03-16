package ru.javarush.sheff.cryptoanalyzer.utils;

import ru.javarush.sheff.cryptoanalyzer.exceptions.AppException;

import java.io.*;
import java.util.HashMap;

public class EncryptOrDecryptFileGenerator {

    public EncryptOrDecryptFileGenerator(HashMap<Character, Character> alphabetOffsetMap, String src, String dest) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(src));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dest))) {
            char sourceChar;
            char offsetChar;
            int symbol = bufferedReader.read();
            while (symbol != -1) {  // When it reaches the end of the file, it will get '-1'
                sourceChar = (char) symbol;// Converted to upper case char
                // If null, then returns the original symbol
                offsetChar = alphabetOffsetMap.getOrDefault(sourceChar, sourceChar);
                bufferedWriter.write(Character.toUpperCase(offsetChar)); // Writing to dest file
                symbol = bufferedReader.read(); // Reading a symbol
            }
        } catch (IOException e) {
            throw new AppException(e);
        }
    }
}
