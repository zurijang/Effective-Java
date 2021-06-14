package ej.study.chapter1.item3;

import java.lang.reflect.Constructor;

public class SingleTest {

    public static void main(String[] args) {
        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton2 singleton1 = Singleton2.getInstance();

        System.out.println(singleton1 == singleton2);

        String name = Singleton3.INSTANCE.getName();
        System.out.println(name);
    }
}
