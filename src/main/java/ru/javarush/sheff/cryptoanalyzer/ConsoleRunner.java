package ru.javarush.sheff.cryptoanalyzer;

import ru.javarush.sheff.cryptoanalyzer.entity.Result;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ConsoleRunner {

    private static Scanner console;
    private static String[] parameters;
    private static String param0;
    private static String param1;
    private static String param2;
    private static String param3;
    private static String param4;

    public static void main(String[] args) {
        Application application = new Application();
        console = new Scanner(System.in);
        System.out.println(hello);
        do {
            selectParam0(console);
            selectParam1(console);
            selectParam2(console);
            selectParam3(console);
            selectParam4(console);
            parametersBuilder();
            Result result = application.run(parameters);
            System.out.println(result);
        } while (console.hasNext());
    }

    public static void selectParam0(Scanner console) {
        System.out.println(selectCommand);
        String selection = console.nextLine();
        try {
            if (selection.isEmpty()) {
                param0 = "encrypt";
            } else if (selection.equalsIgnoreCase("exit")) {
                console.close();
                System.exit(0);
            } else {
                int i = Integer.parseInt(selection);
                if (i == 1) {
                    param0 = "encrypt";
                } else if (i == 2) {
                    param0 = "decrypt";
                } else if (i == 3) {
                    param0 = "bruteforce";
                } else {
                    System.out.println("Unfortunately, this functionality is not yet available.");
                    selectParam0(console);
                }
            }
        } catch (Exception e) {
            System.out.println("You did not enter a valid number");
            selectParam0(console);
        }
    }

    public static void selectParam1(Scanner console) {
        if (param0.equalsIgnoreCase("encrypt")) {
            System.out.println(srcEncode);
        } else if (param0.equalsIgnoreCase("decrypt")) {
            System.out.println(srcDecode);
        } else if (param0.equalsIgnoreCase("bruteforce")) {
            System.out.println(srcBruteForce);
        }
        String selection = console.nextLine();
        try {
            if (selection.isEmpty() && param0.equalsIgnoreCase("encrypt")) {
                param1 = "texts\\Source.txt";
            } else if (selection.isEmpty() && param0.equalsIgnoreCase("decrypt")) {
                param1 = "texts\\Encoded.txt";
            } else if (selection.equalsIgnoreCase("bruteforce")) {
                param1 = "texts\\Encoded.txt";
            } else if (selection.equalsIgnoreCase("exit")) {
                console.close();
                System.exit(0);
            } else {
                Path path = Path.of(selection);
                if (Files.isRegularFile(path)) {
                    param1 = selection;
                } else {
                    if (param0.equalsIgnoreCase("encrypt")) {
                        System.out.println("Default value selected: texts\\Source.txt");
                        param1 = "texts\\Source.txt";
                    } else if (selection.isEmpty() && param0.equalsIgnoreCase("decrypt")) {
                        System.out.println("Default value selected: texts\\Encoded.txt");
                        param1 = "texts\\Encoded.txt";
                    } else if (selection.isEmpty() && param0.equalsIgnoreCase("bruteforce"))
                        param1 = "texts\\Encoded.txt";
                }
            }
        } catch (Exception e) {
            System.out.println("You did not enter a valid path");
            selectParam1(console);
        }
    }

    public static void selectParam2(Scanner console) {
        if (param0.equalsIgnoreCase("encrypt")) {
            System.out.println(langEncrypt);
        } else if (param0.equalsIgnoreCase("decrypt")) {
            System.out.println(langDecrypt);
        } else if (param0.equalsIgnoreCase("bruteforce")) {
            System.out.println("Unfortunately, brute force only works if the file contains English text.");
            param2 = "eng";
            return;
        }
        String selection = console.nextLine();
        try {
            if (selection.isEmpty()) {
                param2 = "eng";
            } else if (selection.equalsIgnoreCase("exit")) {
                console.close();
                System.exit(0);
            } else {
                if (Integer.parseInt(selection) == 2) {
                    param2 = "rus";
                } else {
                    param2 = "eng";
                    System.out.println("The default value has been selected: eng");
                }
            }
        } catch (Exception e) {
            System.out.println("You did not enter a valid number");
            selectParam2(console);
        }
    }

    public static void selectParam3(Scanner console) {
        if (param0.equalsIgnoreCase("encrypt")) {
            System.out.println(destEncrypt);
        } else if (param0.equalsIgnoreCase("decrypt")) {
            System.out.println(destDecrypt);
        } else if (param0.equalsIgnoreCase("bruteforce")) {
            System.out.println(representativeBruteForce);
        }
        String selection = console.nextLine();
        try {
            if (selection.isEmpty() && param0.equalsIgnoreCase("encrypt")) {
                param3 = "texts\\Encoded.txt";
            } else if (selection.isEmpty() && param0.equalsIgnoreCase("decrypt")) {
                param3 = "texts\\Decoded.txt";
            } else if (selection.isEmpty() && param0.equalsIgnoreCase("bruteforce")) {
                param3 = "texts\\Representative.txt";
            } else if (selection.equalsIgnoreCase("exit")) {
                console.close();
                System.exit(0);
            } else {
                Path path = Path.of(selection);
                if (Files.isRegularFile(path)) {
                    param3 = selection;
                } else {
                    System.out.println("Default value selected: texts\\Temp.txt");
                    param3 = "texts\\Temp.txt";
                }
            }
        } catch (Exception e) {
            System.out.println("You did not enter a valid path");
            selectParam3(console);
        }

    }

    public static void selectParam4(Scanner console) {
        if (param0.equalsIgnoreCase("encrypt")) {
            System.out.println(keyEncrypt);
        } else if (param0.equalsIgnoreCase("decrypt")) {
            System.out.println(keyDecrypt);
        } else if (param0.equalsIgnoreCase("bruteforce")) {
            System.out.println(destBruteForce);
        }
        String selection = console.nextLine();
        try {
            if (selection.isEmpty() && param0.equalsIgnoreCase("encrypt")) {
                param4 = "4";
            } else if (selection.isEmpty() && param0.equalsIgnoreCase("decrypt")) {
                param4 = "4";
            } else if (selection.isEmpty() && param0.equalsIgnoreCase("bruteforce")) {
                param4 = "texts\\BruteForceResult.txt";
            } else if (selection.equalsIgnoreCase("exit")) {
                console.close();
                System.exit(0);
            } else {
                Path path = Path.of(selection);
                if (Files.isRegularFile(path) && param0.equalsIgnoreCase("bruteforce")) {
                    param4 = selection;
                } else if (!param0.equalsIgnoreCase("bruteforce")) {
                    param4 = selection;
                } else {
                    System.out.println("Default value selected: texts\\BruteForceResult.txt");
                    param4 = "texts\\BruteForceResult.txt";
                }
            }
        } catch (Exception e) {
            System.out.println("You did not enter a valid path");
            selectParam4(console);
        }
    }

    private static void parametersBuilder() {
        if (param0.isEmpty() || param1.isEmpty() || param2.isEmpty() || param3.isEmpty() || param4.isEmpty()) {
            System.out.println("You did not enter a valid path");
            selectParam0(console);
            selectParam1(console);
            selectParam2(console);
            selectParam3(console);
            selectParam4(console);
            parametersBuilder();
        } else {
            parameters = new String[]{param0, param1, param2, param3, param4};
        }
    }

    private static final String hello = ("""
            ----------------------------------------------------------
            Hello! This is the Caesar-Cipher imitation program.\s
            To exit the program at any time, you can enter "exit".
            ----------------------------------------------------------""");

    private static final String selectCommand = ("""
            Please select a function:
             1. Encrypt from file to file using key\s
             2. Decrypt from file to file using statistical analysis\s
             3. Decrypt from file to file using brute force\s
             4. Decrypt from file to file using statistical analysis\s
             Or press Enter to select the default value - Encryptor""");

    private static final String srcEncode = "Please enter the source file \n" + "or press Enter if you want to select the default file (texts\\Source.txt)";
    private static final String srcDecode = "Please enter the source file \n" + "or press Enter if you want to select the default file (texts\\Encode.txt)";
    private static final String srcBruteForce = "Please enter the source file \n" + "or press Enter if you want to select the default file (texts\\Encode.txt)";

    private static final String langEncrypt = """
            Please enter the language of the file to be encrypted\s
            or press Enter if you want to select the default language (eng)
            1. eng
            2. rus""";

    private static final String langDecrypt = """
            Please enter the language of the file to be decrypted\s
            or press Enter if you want to select the default language (eng)
            1. eng
            2. rus""";

    private static final String destEncrypt = "Please enter the destination file \nor press Enter if you want to select the default file (texts\\Encoded.txt)";

    private static final String destDecrypt = "Please enter the destination file \nor press Enter if you want to select the default file (texts\\Decoded.txt)";

    private static final String destBruteForce = "Please enter the destination file \nor press Enter if you want to select the default file (texts\\BruteForceResult.txt)";

    private static final String representativeBruteForce = "Please enter the representative file \nor press Enter if you want to select the default file (texts\\Representative.txt)";

    private static final String keyEncrypt = "Please enter the key for encryption or press Enter if you want to select the default key (4)";

    private static final String keyDecrypt = "Please enter the key for decryption or press Enter if you want to select the default key (4)";
}
