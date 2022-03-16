package ru.javarush.sheff.cryptoanalyzer.commands;

import ru.javarush.sheff.cryptoanalyzer.entity.*;
import ru.javarush.sheff.cryptoanalyzer.utils.*;

import java.util.HashMap;

public class Encrypt implements Action {
    long currentTimeMillis = System.currentTimeMillis();
    HashMap<Character, Character> alphabetOffsetMap;
    EncryptOrDecryptFileGenerator encryptOrDecryptFileGenerator;
    String src;
    String lang;
    String dest;
    int key;

    @Override
    public Result execute(String[] parameters) {
        src = parameters[0];
        lang = parameters[1];
        dest = parameters[2];
        key = Integer.parseInt(parameters[3]);

        alphabetOffsetMap = new AlphabetOffsetMapGenerator().getAlphabetOffsetMap(lang, key);
        encryptOrDecryptFileGenerator = new EncryptOrDecryptFileGenerator(alphabetOffsetMap, src, dest);

        double commandExecutionTime = ((double) (System.currentTimeMillis() - currentTimeMillis));
        return new Result("Encrypt all right", ResultCode.OK, commandExecutionTime);
    }
}
