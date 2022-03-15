package ru.javarush.sheff.cryptoanalyzer.commands;

import ru.javarush.sheff.cryptoanalyzer.entity.*;

public class BruteForce implements Action {

    long currentTimeMillis = System.currentTimeMillis();

    @Override
    public Result execute(String[] parameters) {
        //TODO there does something

        double commandExecutionTime = ((double) (System.currentTimeMillis() - currentTimeMillis));
        return new Result("Brute force complete", ResultCode.OK, commandExecutionTime);
    }
}
