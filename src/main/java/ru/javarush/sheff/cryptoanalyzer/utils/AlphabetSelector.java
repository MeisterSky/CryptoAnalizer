package ru.javarush.sheff.cryptoanalyzer.utils;

import ru.javarush.sheff.cryptoanalyzer.constants.Constants;
import ru.javarush.sheff.cryptoanalyzer.exceptions.AppException;

public class AlphabetSelector {

    private final char[] alphabet;

    public AlphabetSelector(String lang) {
        switch (lang.toLowerCase()) {
            case "rus" -> alphabet = Constants.RUS_ALPHABET_WITH_SYMBOLS_AND_NUMBERS;
            case "eng" -> alphabet = Constants.ENG_ALPHABET_WITH_SYMBOLS_AND_NUMBERS;
            case "ger" -> alphabet = Constants.GER_ALPHABET_WITH_SYMBOLS_AND_NUMBERS;
            default -> throw new AppException("Invalid language");
        }
    }

    public char[] getAlphabet() {
        return alphabet;
    }
}
