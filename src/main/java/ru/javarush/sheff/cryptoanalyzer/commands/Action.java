package ru.javarush.sheff.cryptoanalyzer.commands;

import ru.javarush.sheff.cryptoanalyzer.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
