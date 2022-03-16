package ru.javarush.sheff.cryptoanalyzer.controllers;

import ru.javarush.sheff.cryptoanalyzer.commands.*;
import ru.javarush.sheff.cryptoanalyzer.exceptions.AppException;

public enum Actions {
    ENCRYPT(new Encrypt()),
    DECRYPT(new Decrypt()),
    BRUTEFORCE(new BruteForce()),
    ANALYZE(new Analyze());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String actionName) {
        try {
            Actions value = Actions.valueOf(actionName.toUpperCase());
            return value.action;
        } catch (IllegalArgumentException e) {
            throw new AppException("not found " + actionName, e);
        }
    }
}
