package cn.hjl.easynotes.designPattern.singletonPattern;



public class Singleton {


    //饿汉式
/*    private Singleton(){

    }
    private static Singleton singleton = new Singleton();

    public static Singleton getInstance(){
        return singleton;
    }*/

    //懒汉式
    /*private Singleton(){

    }

    private static Singleton singleton = null ;

    public static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;

    }*/

    //双向检查锁
    private Singleton(){

    }

    //一定要用volatile修饰，防止new object多部操作，指令重排序导致线程安全问题
    private volatile static Singleton singleton = null;

    public Singleton newInstance(){

        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton = new Singleton();
                }


            }


        }
        return singleton;

    }









}
