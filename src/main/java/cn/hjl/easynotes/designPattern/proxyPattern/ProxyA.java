package cn.hjl.easynotes.designPattern.proxyPattern;

public class ProxyA  implements  A{
    private String name ;
    private RealA realA = null;

    public ProxyA (String name){
        this.name = name;
    }


    @Override
    public void say() {

        if(realA == null){
            realA  = new RealA(this.name);
        }
        realA.say();

    }
}
