package ru.javarush.sheff.cryptoanalyzer.hack;


public class HackFactory {

    public static Hack getCaesarEncryptionHack (String encryptedText, String[] dictionarySource) {
        return new HackFrequencyCharactersAndDictionary(encryptedText, dictionarySource);
    }
}
