package cn.hjl.easynotes.designPattern.ChainOfResponsibilityPattern;

public class Demo {

    public static void main(String[] args) {
        ErrorLogger errorLogger = new ErrorLogger(3);
        InfoLogger infoLogger = new InfoLogger(1);

        errorLogger.setNext(infoLogger);


        AbstractLogger logger = errorLogger;

        errorLogger.say(3);
        errorLogger.say(1);



    }

}
