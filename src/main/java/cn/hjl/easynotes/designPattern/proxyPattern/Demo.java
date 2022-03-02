package cn.hjl.easynotes.designPattern.proxyPattern;

public class Demo {

    public static void main(String[] args) {

        ProxyA proxyA = new ProxyA("AAAA");

        proxyA.say();

        System.out.println("    ");

        proxyA.say();


    }

}
