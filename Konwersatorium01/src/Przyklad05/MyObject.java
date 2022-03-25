package Przyklad05;

public class MyObject implements MyInterface, MyInterface2 {

    @Override
    public void print() {
        System.out.println("Typ: "+this.getClass().getName());
    }

    @Override
    public void print2() {
        System.out.println("Typ2: "+this.getClass().getName());
    }
}
