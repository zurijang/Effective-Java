package ej.study.chapter2.item9;

public class MyResource implements AutoCloseable{

    public void doSomething() {
        System.out.println("Do something");
        throw new FirstError();
    }

    @Override
    public void close() {
        System.out.println("Close My Resource");
        throw new SecondError();
    }
}
