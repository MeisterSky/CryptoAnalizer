package ru.javarush.sheff.cryptoanalyzer.commands;

import ru.javarush.sheff.cryptoanalyzer.entity.*;
import ru.javarush.sheff.cryptoanalyzer.utils.SymbolsFrequencyMapGenerator;

import java.util.HashMap;

public class BruteForce implements Action {

    long currentTimeMillis = System.currentTimeMillis();
    HashMap<Character, Integer> symbolsFrequencyMap;
    String src;
    String lang;
    String representative;
    String dest;

    @Override
    public Result execute(String[] parameters) {
        src = parameters[0];
        lang = parameters[1];
        representative = parameters[2];
        dest = parameters[3];
        symbolsFrequencyMap = new SymbolsFrequencyMapGenerator().getSymbolsFrequencyMap(representative);

             double commandExecutionTime = ((double) (System.currentTimeMillis() - currentTimeMillis));
        return new Result("Brute force complete", ResultCode.OK, commandExecutionTime);
    }
}
