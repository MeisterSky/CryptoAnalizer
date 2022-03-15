package ru.javarush.sheff.cryptoanalyzer.controllers;

import ru.javarush.sheff.cryptoanalyzer.commands.Action;
import ru.javarush.sheff.cryptoanalyzer.entity.Result;

public class MainController {

    public Result doAction(String actionName, String[] parameters) {
        Action action = Actions.find(actionName);
        return action.execute(parameters);
    }
}
