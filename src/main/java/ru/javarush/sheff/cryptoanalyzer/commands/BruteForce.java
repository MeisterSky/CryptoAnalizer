package ru.javarush.sheff.cryptoanalyzer.commands;

import ru.javarush.sheff.cryptoanalyzer.entity.Result;
import ru.javarush.sheff.cryptoanalyzer.entity.ResultCode;
import ru.javarush.sheff.cryptoanalyzer.utils.AlphabetSelector;
import ru.javarush.sheff.cryptoanalyzer.utils.BruteForceFileGenerator;

public class BruteForce implements Action {
    long currentTimeMillis = System.currentTimeMillis();
    BruteForceFileGenerator bruteForceFileGenerator;
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
        bruteForceFileGenerator = new BruteForceFileGenerator(alphabet, src, dest);

        double commandExecutionTime = ((double) (System.currentTimeMillis() - currentTimeMillis));
        return new Result("Decrypt all right", ResultCode.OK, commandExecutionTime);
    }
}
