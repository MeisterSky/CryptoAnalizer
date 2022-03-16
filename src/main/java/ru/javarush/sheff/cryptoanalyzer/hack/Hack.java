package ru.javarush.sheff.cryptoanalyzer.hack;

public interface Hack {
    String hack();
    void correctEncryptionTableWithHand(String fromSymbol, String toSymbol);
}