package ej.study.chapter4.item19;

import java.time.Instant;

public final class Sub extends Super {
    // 초기화되지 않은 final 필드. 생성자에서 초기화한다.
    private final Instant instant;
    Sub() {
        instant = Instant.now();
    }

    // 재정의 가능 메서드. 상위 클래스의 생성자가 호출한다.
    @Override public void overrideMe() {
        System.out.println(instant);
    }

//    @Override public void protectedMethod() {
//        System.out.println("재정의");
//    }

    public static void main(String args[]) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}