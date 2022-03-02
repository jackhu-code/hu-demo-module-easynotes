package cn.hjl.easynotes.designPattern.ChainOfResponsibilityPattern;

public class ErrorLogger extends AbstractLogger{


    private int level;

    public ErrorLogger(int level){
        this.level = level;
    }


    @Override
    protected void write(int message) {
        System.out.println(message);
    }
}
