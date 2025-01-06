package _08_ChainOfReponsibilityDP._01_LoggerDesignPattern;

public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.log(LogProcessor.DEBUG,"debug message");
        logProcessor.log(LogProcessor.INFO,"info message");
        logProcessor.log(LogProcessor.ERROR,"error message");


    }
}
