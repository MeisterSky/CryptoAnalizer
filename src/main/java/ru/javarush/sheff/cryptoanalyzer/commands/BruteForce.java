package ru.javarush.sheff.cryptoanalyzer.commands;

import ru.javarush.sheff.cryptoanalyzer.entity.*;

public class BruteForce implements Action{
    @Override
    public Result execute(String[] parameters)  {
        //TODO there does something
        return new Result("BruteForce complete", ResultCode.OK);
    }
}
