package cn.hjl.easynotes.designPattern.ChainOfResponsibilityPattern;

public abstract class  AbstractLogger {


    private  int level;



    private AbstractLogger next ;

    public void setNext(AbstractLogger next){

        this.next = next;

    }

    public  void say(int level){
        if(this.level <= level){
            write(level);
            return;
        }

        if(next !=null){
            next.say(level);
        }


    }



    abstract void write(int message);



}
