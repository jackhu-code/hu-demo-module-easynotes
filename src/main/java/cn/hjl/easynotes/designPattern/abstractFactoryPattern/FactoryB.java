package cn.hjl.easynotes.designPattern.abstractFactoryPattern;

public class FactoryB implements Factory{
    @Override
    public food get() {
        return new B();
    }
}
