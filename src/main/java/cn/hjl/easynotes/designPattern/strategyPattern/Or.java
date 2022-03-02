package cn.hjl.easynotes.designPattern.strategyPattern;

public class Or  implements Strategy{
    @Override
    public void opration() {
        System.out.println("Or");
    }
}
