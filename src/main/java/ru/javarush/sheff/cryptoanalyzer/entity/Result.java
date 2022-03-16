package ru.javarush.sheff.cryptoanalyzer.entity;

public class Result {
    private final String message;
    private final ResultCode resultCode;
    private final double commandExecutionTime;

    public Result(String message, ResultCode resultCode, double commandExecutionTime) {
        this.message = message;
        this.resultCode = resultCode;
        this.commandExecutionTime = commandExecutionTime;
    }

    @Override
    public String toString() {
        return "Result " +
                "message: \"" + message + "\"" +
                ", Result code: " + "\"" + resultCode + "\"" +
                ", Command execution time: " + "\"" + commandExecutionTime + "ms" + "\"";
    }
}
