package ru.javarush.sheff.cryptoanalyzer.utils;

import ru.javarush.sheff.cryptoanalyzer.exceptions.AppException;

import java.io.*;

public class BruteForceFileGenerator {

    public BruteForceFileGenerator(char[] alphabet, String src, String dest) {
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(src)));
             BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(dest)))) {
            int iterator = 0;
            StringBuilder builder = new StringBuilder();

            while (reader.ready()) {
                char[] buffer = new char[64];
                reader.read(buffer);

                for (int i = 0; i < alphabet.length; i++) {
                    for (char c : buffer) {
                        for (int j = 0; j < alphabet.length; j++) {
                            if (String.valueOf(c).equalsIgnoreCase(String.valueOf(alphabet[j]))) {
                                builder.append(alphabet[(j + i) % alphabet.length]);
                            }
                        }
                    }
                    if (builder.toString().contains(", ")) {
                        iterator = i;
                        builder.delete(0, builder.length());
                    }
                }

                for (int i = 0; i < buffer.length; i++) {
                    for (int j = 0; j < alphabet.length; j++) {
                        if (String.valueOf(buffer[i]).equalsIgnoreCase(String.valueOf(alphabet[j]))) {
                            buffer[i] = alphabet[(j + iterator) % alphabet.length];
                            break;
                        }
                    }
                }

                System.out.println(iterator);
                writer.write(buffer);
                writer.flush();

            }

        } catch (IOException e) {
            throw new AppException(e);
        }
    }
}
