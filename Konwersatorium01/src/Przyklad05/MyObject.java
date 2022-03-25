package Przyklad05;

public class MyObject implements MyInterface {

    @Override
    public void print() {
        System.out.println("Typ: "+this.getClass().getName());
    }
}
