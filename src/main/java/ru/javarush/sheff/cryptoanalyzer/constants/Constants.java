package ru.javarush.sheff.cryptoanalyzer.constants;

public class Constants {
    private static final String rus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String eng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ger = "ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜß";

    public static final char[] RUS_ALPHABET = (rus + rus.toLowerCase()).toCharArray();
    public static final char[] ENG_ALPHABET = (eng + eng.toLowerCase()).toCharArray();
    public static final char[] GER_ALPHABET = (ger + ger.toLowerCase()).toCharArray();
}
