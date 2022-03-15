package ru.javarush.sheff.cryptoanalyzer.commands;

import ru.javarush.sheff.cryptoanalyzer.entity.*;
import ru.javarush.sheff.cryptoanalyzer.utils.AlphabetOffsetGenerator;

import java.io.*;
import java.util.HashMap;

public class Encrypt implements Action {

    HashMap<Character, Character> alphabetOffsetMap;

    @Override
    public Result execute(String[] parameters) {
        alphabetOffsetMap = new AlphabetOffsetGenerator().getAlphabetOffsetMap(Integer.parseInt(parameters[2]));
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(parameters[0]));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(parameters[1]))) {
            char sourceChar;
            char offsetChar;
            int symbol = bufferedReader.read();
            while (symbol != -1) {  // When it reaches the end of the file, it will get '-1'
                sourceChar = (char) symbol; // Converted to char
                offsetChar = alphabetOffsetMap.get(sourceChar) != null ? alphabetOffsetMap.get(sourceChar) : sourceChar; // If null, then returns the original char
                bufferedWriter.write(offsetChar); // Writing to dest file
                symbol = bufferedReader.read(); // Reading a symbol
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Result("encrypt all right", ResultCode.OK);
    }
}