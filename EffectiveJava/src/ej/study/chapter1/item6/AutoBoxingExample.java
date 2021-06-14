package ej.study.chapter1.item6;

public class AutoBoxingExample {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = 0l;   // Long과 long의 차이 : Long은 객체를 새로 생성. long이 훨씬 빠르다.
        for (long i = 0 ; i <= Integer.MAX_VALUE ; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - start);
    }
}
