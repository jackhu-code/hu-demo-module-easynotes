package cn.hjl.easynotes;

import cn.hjl.easynotes.demo.MyCallable;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        System.out.println("hello word!");
//
//        System.out.println("胡子豪");
//
//        System.out.println( Math.max(5,10) );
//        Date date = new Date();
//        System.out.println( "今天是"+ date );
//
//        //信号量
//        Semaphore semaphore = new Semaphore(10);
//
//        semaphore.tryAcquire();
//
//        semaphore.release();
//
//        //栅栏
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
//
//
//        //同步锁
//        CountDownLatch countDownLatch = new CountDownLatch(10);

//        System.out.println(Math.round(-1.499999999));
//
//
//        StringBuilder sb = new StringBuilder("胡京礼是个大帅哥");
//        sb.reverse();
//        System.out.println(sb.toString());
//
//        File file = new File("");
//        try {
//            Files.delete(Paths.get(""));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        /*MyCallable ca = new MyCallable();
        FutureTask task = new FutureTask(ca);
        Thread.sleep(2000);
        task.run();
        Thread.sleep(2000);
        Object o = task.get();
        System.out.println(o);*/

        /*Object o1 = new Object();
        Object o2 = new Object();


        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {

                synchronized (o1){
                    System.out.println(1);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (o2){
                        System.out.println(2);
                    }
                }

            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {

                synchronized (o2){
                    System.out.println(3);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o1){
                        System.out.println(4);
                    }


                }

            }
        };


        new Thread(runnable1).start();
        new Thread(runnable2).start();*/



        /**
         * 创建对象的代理对象
         * 参数一：类加载器
         * 参数二：对象的接口
         * 参数三：调用处理器，代理对象中的方法被调用，都会在执行方法。对所有被代理对象的方法进行拦截
         */
        Object obj = new Object();
        Object proxyInstance = Proxy.newProxyInstance(obj.getClass().getClassLoader()
                , obj.getClass().getInterfaces(), new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //方法执行前
                        System.out.println("方法增强了1");
                        Object result = method.invoke(obj, args);//执行方法的调
                        System.out.println("方法增强了2");

                        return result;
                    }
                });
        proxyInstance.toString();

        /**
         * 使用CGLib的Enhancer创建代理对象
         * 参数一：对象的字节码文件
         * 参数二：方法的拦截器
         */
        Object proxyObj = Enhancer.create(obj.getClass(), new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //方法执行前
                System.out.println("方法增强了3");
                Object invokeObject = method.invoke(obj, objects);//执行方法的调用
                System.out.println("方法增强了4");
                return invokeObject;
            }
        });
        proxyObj.toString();


    }
}



