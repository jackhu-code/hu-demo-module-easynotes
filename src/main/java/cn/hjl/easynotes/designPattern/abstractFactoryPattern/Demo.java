package cn.hjl.easynotes.designPattern.abstractFactoryPattern;

public class Demo {
    public static void main(String[] args) {


        food f = new FactoryA().get();
        food b = new FactoryB().get();


    }
}
