package cn.hjl.easynotes.designPattern.proxyPattern;

public class RealA implements A{

    private String name ;

    public RealA(String name){
        this.name = name ;
        System.out.println("构造");
    }


    @Override
    public void say() {
        System.out.println("你好");
    }
}
