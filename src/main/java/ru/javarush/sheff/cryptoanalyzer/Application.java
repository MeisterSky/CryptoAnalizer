package ru.javarush.sheff.cryptoanalyzer;

import ru.javarush.sheff.cryptoanalyzer.entity.Result;
import ru.javarush.sheff.cryptoanalyzer.exceptions.AppException;

import java.util.Arrays;

import ru.javarush.sheff.cryptoanalyzer.controllers.MainController;

public class Application {

    private final MainController mainController;

    public Application() {
        mainController = new MainController();
    }

    public Result run(String[] args) {
        if (args.length > 0) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            return mainController.doAction(action, parameters);
        } else {
            throw new AppException("no args");
        }
    }
}
