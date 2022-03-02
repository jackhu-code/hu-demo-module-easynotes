package cn.hjl.easynotes.designPattern.strategyPattern;

public class Context {

    private Strategy strategy ;


    public Context(Strategy strategy){
        this.strategy = strategy ;
    }

    public void opration(){
        strategy.opration();
    }


}
