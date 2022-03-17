package ru.javarush.sheff.cryptoanalyzer.commands;

import ru.javarush.sheff.cryptoanalyzer.entity.Result;
import ru.javarush.sheff.cryptoanalyzer.entity.ResultCode;
import ru.javarush.sheff.cryptoanalyzer.exceptions.AppException;
import ru.javarush.sheff.cryptoanalyzer.utils.AlphabetSelector;

import java.io.*;

public class BruteForce implements Action {
    long currentTimeMillis = System.currentTimeMillis();
    String src;
    String lang;
    String dest;
    char[] alphabet;

    @Override
    public Result execute(String[] parameters) {
        src = parameters[0];
        lang = parameters[1];
        dest = parameters[2];
        alphabet = new AlphabetSelector(lang).getAlphabet();

        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(src)));
             BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(dest)))) {
            while (reader.ready()) {
                char[] buffer = new char[64];
                reader.read(buffer);
                int iterator = 0;
                for (int i = 0; i < buffer.length; i++) {
                    for (int j = 0; j < alphabet.length; j++) {
                        if (String.valueOf(buffer[i + j]).equalsIgnoreCase(String.valueOf(',')) && String.valueOf(buffer[i + j + 1]).equalsIgnoreCase(String.valueOf(' '))
                                || String.valueOf(buffer[i + j]).equalsIgnoreCase(String.valueOf(' '))) {
                            buffer[i] = alphabet[iterator];
                            break;
                        } else {
                            iterator = j;
                        }
                    }
                }
                writer.write(buffer);
                writer.flush();
            }
        } catch (IOException e) {
            throw new AppException(e);
        }
        double commandExecutionTime = ((double) (System.currentTimeMillis() - currentTimeMillis));
        return new Result("Decrypt all right", ResultCode.OK, commandExecutionTime);
    }
}
