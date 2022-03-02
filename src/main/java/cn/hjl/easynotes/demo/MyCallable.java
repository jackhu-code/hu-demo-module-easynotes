package cn.hjl.easynotes.demo;

import java.util.concurrent.Callable;

public class MyCallable  implements Callable {
    @Override
    public Object call() throws Exception {

        System.out.println("call is run ");

        return "call";
    }
}
