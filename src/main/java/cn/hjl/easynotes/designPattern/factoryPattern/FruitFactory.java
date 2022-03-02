package cn.hjl.easynotes.designPattern.factoryPattern;

public class FruitFactory {

    public static Fruit getFruit(String type){
        if("apple".equals(type)){
            return new Apple();
        }else if("orange".equals(type)){
            return new Orange();
        }else {
            System.out.println("没有这种水果");
            return null;
        }
    }



}
