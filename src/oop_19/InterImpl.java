package oop_19;

public class InterImpl implements Inter{
    @Override
    public void method(){
        System.out.println("實現類重寫的抽象方法");
    }

    @Override
    public void show(){
        System.out.println("interface中的 show 方法");
    }
}
