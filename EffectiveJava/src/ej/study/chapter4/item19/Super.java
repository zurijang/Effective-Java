package ej.study.chapter4.item19;

// 해당 클래스를 상속받지 못하게 하려면 final로 선언
// 클래스에 변화가 생길 때마다 하위 클래스를 오동작하게 만들 수 있음
public class Super {
    // 잘못 된 예 - 생성자가 재정의 가능 메서드를 호출한다.
    public Super() {
        testMethod(); // 상속용으로 설계되지 않은 클래스라도 꼭 상속을 허용해야 한다면 Override를 원하지 않는 메서드는 private로 선언
        protectedMethod();
    }


    // shift 2번 + generate javadoc
    // 한글 주석 에러 : Other Command line arguments에 -locale ko_KR -encoding UTF-8 -charset UTF-8 -docencoding UTF-8 추가
    /**
     * @ImplSpec
     * <p>This method Test
     * No parameter
     * overrideMe
     * Effective 자바
     * </p>
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    public void overrideMe() {
        System.out.println("Test");
    }

    private void testMethod() {
        System.out.println("Test Method");
    }

    // protected 메서드 하나하나가 내부 구현에 해당
   protected void protectedMethod() {
        System.out.println("protected method");
    }

}