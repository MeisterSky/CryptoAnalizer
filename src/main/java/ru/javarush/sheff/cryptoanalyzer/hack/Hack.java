package ru.javarush.sheff.cryptoanalyzer.hack;

//TODO Correct encryption table with hand for user
public interface Hack {
    String hack();
    void correctEncryptionTableWithHand(String fromSymbol, String toSymbol);
}