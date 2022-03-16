package ru.javarush.sheff.cryptoanalyzer.utils;

import java.util.Map;

public class HackUtils {

    public static String getKeyByValue(Map<String, String> map, String value) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if ( value.equals(entry.getValue()) ) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static Boolean containsKeyWithValue(String key, String value, Map map) {
        return (map.containsKey(key) && map.get(key).equals(value));
    }

}
