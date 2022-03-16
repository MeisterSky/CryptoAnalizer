package ru.javarush.sheff.cryptoanalyzer.constants;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class HackParameters {
    public static Integer maxWordsDistance = 1;
    public static Integer maxSymbolDistance = 6;
    public static Integer minWordLength = 6;
    public static Pattern wordPattern = Pattern.compile("[a-zA-Z]{" + minWordLength + ",}");

    public static List<String> charactersWithFrequencyDescending = Arrays.asList(
            "E", "A", "T", "N", "I", "O", "S", "H", "R", "Q", "L", "U", "C",
            "M", "F", "Y", "P", "W", "G", "V", "B", "K", "J", "X", "D", "Z");

    public static List<String> encryptionAlphabet = List.of(
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
}
