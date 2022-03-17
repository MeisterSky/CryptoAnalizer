package ru.javarush.sheff.cryptoanalyzer.constants;

import java.util.Arrays;
import java.util.List;

public class Constants {
    private static final String rus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String eng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ger = "ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜß";
    private static final String symbols = "-,.:; «»\"\\!?";

    public static final char[] RUS_ALPHABET = (rus + rus.toLowerCase() + symbols).toCharArray();
    public static final char[] ENG_ALPHABET = (eng + eng.toLowerCase() + symbols).toCharArray();
    public static final char[] GER_ALPHABET = (ger + ger.toLowerCase() + symbols).toCharArray();

    public static final List<String> encryptionAlphabetList = Arrays.asList(eng.split(""));

    public static final List<String> charactersWithFrequencyDescendingList = Arrays.asList(
            "E", "A", "T", "N", "I", "O", "S", "H", "R", "Q", "L", "U", "C",
            "M", "F", "Y", "P", "W", "G", "V", "B", "K", "J", "X", "D", "Z");

}
