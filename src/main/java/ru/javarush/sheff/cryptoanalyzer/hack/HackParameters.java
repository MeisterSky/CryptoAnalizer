package ru.javarush.sheff.cryptoanalyzer.hack;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class HackParameters {
    public static Integer maxWordsDistance = 1;
    public static Integer maxSymbolDistance = 6;
    public static Integer minWordLength = 6;
    public static Pattern wordPattern = Pattern.compile("[a-zA-Z]{" + minWordLength + ",}");
}
