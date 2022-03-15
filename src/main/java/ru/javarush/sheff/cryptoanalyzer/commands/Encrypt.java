package ru.javarush.sheff.cryptoanalyzer.commands;

import ru.javarush.sheff.cryptoanalyzer.entity.*;
import ru.javarush.sheff.cryptoanalyzer.utils.AlphabetOffsetGenerator;
import ru.javarush.sheff.cryptoanalyzer.utils.FileGenerator;

import java.util.HashMap;

public class Encrypt implements Action {

    long currentTimeMillis = System.currentTimeMillis();
    HashMap<Character, Character> alphabetOffsetMap;
    FileGenerator fileGenerator;

    @Override
    public Result execute(String[] parameters) {
        //Need a positive value to decrypt
        alphabetOffsetMap = new AlphabetOffsetGenerator().getAlphabetOffsetMap(Integer.parseInt(parameters[2]));
        fileGenerator = new FileGenerator(alphabetOffsetMap, parameters[0], parameters[1]);
        double commandExecutionTime = ((double) (System.currentTimeMillis() - currentTimeMillis));
        return new Result("Encrypt all right", ResultCode.OK, commandExecutionTime);
    }
}
