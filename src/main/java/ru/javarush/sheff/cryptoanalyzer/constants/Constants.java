package ru.javarush.sheff.cryptoanalyzer.constants;

public class Constants {
    private static final String rus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String eng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ger = "ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜß";
    private static final String symbols = "☮!@#$%^&*/—-+=()[]{}? .,;:'\"";
    private static final String numbers = "0123456789";

    public static final char[] RUS_ALPHABET_WITH_SYMBOLS_AND_NUMBERS = (rus + rus.toLowerCase() + symbols + numbers).toCharArray();
    public static final char[] ENG_ALPHABET_WITH_SYMBOLS_AND_NUMBERS = (eng + eng.toLowerCase() + symbols + numbers).toCharArray();
    public static final char[] GER_ALPHABET_WITH_SYMBOLS_AND_NUMBERS = (ger + ger.toLowerCase() + symbols + numbers).toCharArray();
}
