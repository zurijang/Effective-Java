package ej.study.chapter1.Item4;

import sun.nio.ch.Util;

// abstract class 를 만들면 1차적으로 객체 생성을 막을 수 있음
// abstract로만 막아도 충분한 것 같음
public abstract class UtilClass {

    // 유틸 클래스라 인스턴스를 만들지 못하게 막음
    private UtilClass() {
        throw new AssertionError();
    }

    public static String getName() {
        return "zuri";
    }

    static class AnotherClass extends UtilClass {

    }

    public static void main(String[] args) {

        AnotherClass anotherClass = new AnotherClass(); // 인스턴스를 만들 수 있지만, 메서드는 사용 불가 : 의미 없음

        UtilClass.getName();
    }
}
