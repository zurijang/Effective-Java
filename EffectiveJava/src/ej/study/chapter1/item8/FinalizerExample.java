package ej.study.chapter1.item8;

public class FinalizerExample {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Clean up");
    }

    public void hello() {
        System.out.println("hi");
    }
}
