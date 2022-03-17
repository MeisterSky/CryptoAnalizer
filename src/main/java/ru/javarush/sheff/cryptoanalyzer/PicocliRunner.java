package ru.javarush.sheff.cryptoanalyzer;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;
import ru.javarush.sheff.cryptoanalyzer.entity.Result;

@Command(name = "cypher", subcommands = {CommandLine.HelpCommand.class},
        description = "Caesar cypher command")
public class PicocliRunner implements Runnable {

    private final Application application = new Application();
    @Spec
    CommandSpec spec;

    @Command(name = "encrypt", description = "Encrypt from file to file using key")
    void encrypt(
            @Parameters(paramLabel = "<source file>", description = "source file with text to encrypt") String src,
            @Parameters(paramLabel = "<language>", description = "the language of the file to be encrypted") String lang,
            @Parameters(paramLabel = "<dest file>", description = "dest file which should have encrypted text") String dest,
            @Parameters(paramLabel = "<key>", description = "key for encryption") String key) {
        String[] args = {"encrypt", src, lang, dest, key};
        Result result = application.run(args);
        System.out.println(result);
    }

    @Command(name = "decrypt", description = "Decrypt from file to file using statistical analysis")
    void decrypt(
            @Parameters(paramLabel = "<source file>", description = "source file with encrypted text") String src,
            @Parameters(paramLabel = "<language>", description = "the language of the file to be decrypted") String lang,
            @Parameters(paramLabel = "<dest file>", description = "dest file which should have decrypted text") String dest,
            @Parameters(paramLabel = "<key>", description = "key for encryption") String key) {
        String[] args = {"decrypt", src, lang, dest, key};
        Result result = application.run(args);
        System.out.println(result);
    }

    @Command(name = "bruteforce", description = "Decrypt from file to file using brute force")
    void bruteForce(
            @Parameters(paramLabel = "<source file>", description = "source file with encrypted text") String src,
            @Parameters(paramLabel = "<language>", description = "the language of the file to be decrypted") String lang,
            @Parameters(paramLabel = "<dest file>", description = "dest file which should have decrypted text") String dest) {
        String[] args = {"bruteforce", src, lang, dest};
        Result result = application.run(args);
        System.out.println(result);
    }

    @Command(name = "analyze", description = "Decrypt from file to file using statistical analysis")
    void statisticalDecrypt(
            @Parameters(paramLabel = "<source file>", description = "source file with encrypted text") String src,
            @Parameters(paramLabel = "<language>", description = "the language of the file to be decrypted") String lang,
            @Parameters(paramLabel = "<dest file>", description = "dest file which should have decrypted text") String dest,
            @Parameters(paramLabel = "representative", description = "file with unencrypted representative text") String representative) {
        String[] args = {"analyze", src, lang, dest, representative};
        Result result = application.run(args);
        System.out.println(result);
    }

    @Override
    public void run() {
        throw new ParameterException(spec.commandLine(), "Specify a subcommand");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new PicocliRunner()).execute(args);
        System.exit(exitCode);
    }
}
