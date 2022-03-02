package cn.hjl.easynotes.designPattern.templateMethodPattern;

public abstract class A {

    abstract void m1();
    abstract void m2();
    abstract void m3();


    public  final void  say(){

        m1();
        m2();
        m3();


    }



}
