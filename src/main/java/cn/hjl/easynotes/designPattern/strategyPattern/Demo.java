package cn.hjl.easynotes.designPattern.strategyPattern;

public class Demo {
    public static void main(String[] args) {

        Context context = new Context(new Add());
        context.opration();
        Context c = new Context(new Or());
        c.opration();

    }
}
