package cn.hjl.easynotes.designPattern.builderPattern;

public class Demo {

    public static void main(String[] args) {

        Student A = new Student.Builder().setName("胡经理").setAge("20").build();


    }
}
