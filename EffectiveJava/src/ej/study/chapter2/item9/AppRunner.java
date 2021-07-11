package ej.study.chapter2.item9;

public class AppRunner {

    public static void main(String[] args) {
        // 디버깅이 좋아짐 자바 7 이후부터
        try(MyResource myResource = new MyResource();
            MyResource myResource1 = new MyResource()) {
            myResource.doSomething();
            myResource1.doSomething();
        }
    }
}
