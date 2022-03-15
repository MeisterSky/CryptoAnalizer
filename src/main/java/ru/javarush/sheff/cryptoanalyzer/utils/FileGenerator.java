package ru.javarush.sheff.cryptoanalyzer.utils;

import ru.javarush.sheff.cryptoanalyzer.exceptions.AppException;

import java.io.*;
import java.util.HashMap;

public class FileGenerator {

    public FileGenerator(HashMap<Character, Character> alphabetOffsetMap, String... parameters) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(parameters[0]));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(parameters[1]))) {
            char sourceChar;
            char offsetChar;
            int symbol = bufferedReader.read();
            while (symbol != -1) {  // When it reaches the end of the file, it will get '-1'
                sourceChar = (char) symbol; // Converted to char
                // If null, then returns the original symbol
                offsetChar = alphabetOffsetMap.get(sourceChar) != null ? alphabetOffsetMap.get(sourceChar) : sourceChar;
                bufferedWriter.write(offsetChar); // Writing to dest file
                symbol = bufferedReader.read(); // Reading a symbol
            }
        } catch (IOException e) {
            throw new AppException(e);
        }
    }
}
