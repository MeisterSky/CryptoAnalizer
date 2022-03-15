package ru.javarush.sheff.cryptoanalyzer.constants;

public class Constants {
    private static final String rus = "ЁЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ";
    private static final String eng = "QWERTYUIOPLKJHGFDSAZXCVBNM";
    private static final String numbers = "0123456789";
    private static final String symbols = "☮!@#$%^&*/—-+=()[]{}? .,;:'\"";

    public static final char[] ALPHABET = (rus + eng + rus.toLowerCase() + eng.toLowerCase() + numbers + symbols).toCharArray();
}
