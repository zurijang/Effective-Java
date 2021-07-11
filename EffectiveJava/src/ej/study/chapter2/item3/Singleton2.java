package ej.study.chapter2.item3;

public class Singleton2 {

    private static final Singleton2 instance = new Singleton2();

    private Singleton2 () {

    }

    // new 로 객체 선언하면 호출될 때마다 새로운 객체가 생성되기 때문에 싱글톤에 어긋남
    public static Singleton2 getInstance() {
        return instance;
    }

}
