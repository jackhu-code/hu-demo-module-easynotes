package cn.hjl.easynotes.designPattern.strategyPattern;

public class Add implements Strategy{
    @Override
    public void opration() {
        System.out.println("add");
    }
}
