package ru.javarush.sheff.cryptoanalyzer.commands;

import ru.javarush.sheff.cryptoanalyzer.entity.*;
import ru.javarush.sheff.cryptoanalyzer.exceptions.AppException;
import ru.javarush.sheff.cryptoanalyzer.utils.SymbolsFrequencyMapGenerator;
import ru.javarush.sheff.cryptoanalyzer.hack.Hack;
import ru.javarush.sheff.cryptoanalyzer.hack.HackFactory;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;


public class Analyze implements Action {
    long currentTimeMillis = System.currentTimeMillis();
    HashMap<Character, Integer> symbolsFrequencyMap;
    String src;
    String lang;
    String representative;
    String dest;
    String encryptedText;
    String hackedText;

    @Override
    public Result execute(String[] parameters) {
        src = parameters[0];
        lang = parameters[1];
        dest = parameters[2];
        representative = parameters[3];

        symbolsFrequencyMap = new SymbolsFrequencyMapGenerator().getSymbolsFrequencyMap(representative);
        encryptedText = readEncryptedFiles(src);

        File file = new File(representative);
        List<String> fileLines;

        try {
            fileLines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new AppException(e);
        }

        String[] dictionary = fileLines.toArray(new String[0]);

        Hack hack = HackFactory.getCaesarEncryptionHack(encryptedText, dictionary);
        hackedText = hack.hack();
        writeDecryptedFiles(hackedText, dest);

        double commandExecutionTime = ((double) (System.currentTimeMillis() - currentTimeMillis));
        return new Result("Brute force complete", ResultCode.OK, commandExecutionTime);
    }

    private String readEncryptedFiles(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            throw new AppException(e);
        }
    }

    private static void writeDecryptedFiles(String data, String dest) {
        try {
            Files.write(Paths.get(dest), data.getBytes());
        } catch (IOException e) {
            throw new AppException(e);
        }
    }
}
