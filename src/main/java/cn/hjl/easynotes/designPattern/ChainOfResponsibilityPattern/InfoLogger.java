package cn.hjl.easynotes.designPattern.ChainOfResponsibilityPattern;

public class InfoLogger extends AbstractLogger{

    private int level;

    public InfoLogger(int level){
        this.level = level;
    }


    @Override
    protected void write(int message) {
        System.out.println(message);
    }
}
