package ru.javarush.sheff.cryptoanalyzer.hack;

import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;

class HackFrequencyCharactersAndDictionary extends HackAbstract implements Hack {
    private final HashSet<String> dictionary;

    @Override
    public String hack() {
        correctEncryptionTableWithDictionary();
        return decryptTextWithEncryptionTable(this.encryptedText);
    }

    public HackFrequencyCharactersAndDictionary(String encryptedText, String[] sourceOfDictionary) {
        super(encryptedText);
        this.dictionary = DictionaryForHacking.getDictionary(sourceOfDictionary);
        correctEncryptionTableWithDictionary();
    }

    public void correctEncryptionTableWithDictionary() {
        Matcher wordsMatches = HackParameters.wordPattern.matcher(encryptedText);

        while (wordsMatches.find()) {
            String encryptedWord = wordsMatches.group();
            encryptedWord = encryptedWord.toLowerCase();
            String decryptedWord = decryptTextWithEncryptionTable(encryptedWord);

            correctEncryptionTableWithDecryptedWordAndDictionary(decryptedWord);
        }
    }

    @Override
    protected Map<String, String> getHackedEncryptionTable(String encryptedText) {
        return FrequencyCharactersForHacking.getHackedEncryptionTable(encryptedText);
    }

    private void correctEncryptionTableWithDecryptedWordAndDictionary(String decryptedWord) {
        String closestWord = DictionaryForHacking.findClosestWordInDictionary(decryptedWord, this.dictionary);

        if ( closestWord.equals("") )
            return;

        for (int i = 0; i < decryptedWord.length(); i++) {
            String decryptedSymbol = String.valueOf( decryptedWord.charAt(i) );
            String correctSymbol = String.valueOf( closestWord.charAt(i) );
            if ( !decryptedSymbol.equals(correctSymbol) ) {
                this.encryptionTable = replaceSymbolInEncryptionTable(encryptionTable, decryptedSymbol, correctSymbol);
            }
        }
    }
}
