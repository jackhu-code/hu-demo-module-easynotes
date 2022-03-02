package cn.hjl.easynotes.designPattern.abstractFactoryPattern;

public class FactoryA implements Factory{

    @Override
    public food get() {
        return new A();
    }
}
