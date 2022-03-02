package cn.hjl.easynotes.designPattern.Decoratorpattern;


public class ClientTest {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        System.out.println("------装饰前：-------");
        component.function();
        Component newComponent = new ConcreteDecorator(component);
        System.out.println("------装饰后：-------");
        newComponent.function();
    }
}