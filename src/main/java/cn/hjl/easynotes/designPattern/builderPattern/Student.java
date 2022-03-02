package cn.hjl.easynotes.designPattern.builderPattern;

public class Student {

    private String name;
    private String age;
    private String sex;

    public Student(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
    }



    static class Builder{
        private String name;
        private String age ;
        private String sex ;

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setAge(String age ){
            this.age = age;
            return this;
        }

        public Builder setSex(String sex){
            this.sex = sex;
            return this;
        }

        public Student build(){
            return new Student(this);
        }



    }







}
