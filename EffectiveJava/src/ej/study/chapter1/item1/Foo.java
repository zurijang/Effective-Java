package ej.study.chapter1.item1;

import java.util.EnumSet;

public class Foo {

    String name;
    String address;

    private static final Foo GOOD_NIGHT = new Foo();

    public Foo() {

    }

    public Foo(String name) {
        this.name = name;
    }

    public static Foo withName(String name) {
        return new Foo(name);
    }

    public static Foo withAddress(String address) {
        Foo foo = new Foo();
        foo.address = address;
        return foo;
    }

    public static Foo getFoo() {
        return GOOD_NIGHT;
    }

    public static Foo getFoo(boolean flag) {
        return flag ? new Foo() : new BarFoo();
    }

    public static Foo GetFoo2(boolean falg) {
        Foo foo = new Foo();

        // TODO 어떤 특정 약속 되어 있는 텍스트 파일에서 Foo 구현체의 FQCN 을 읽어온다.
        // TODO FQCN 에 해당하는 인스턴스를 생성한다.
        // TODO foo 변수를 해당 인스턴스를 가리키도록 수정한다.

        return foo;
    }

    public static void main(String[] args) {
        Foo foo = new Foo("zuri");
        Foo foo1 = Foo.withName("zuri");
        Foo foo2 = Foo.withAddress("daejeon");

        System.out.println(foo==foo1);

        Foo foo3 = Foo.getFoo();
        Foo foo4 = Foo.getFoo(false);

        System.out.println(foo3 == foo4);

        EnumSet<Color> colors = EnumSet.allOf(Color.class);

        EnumSet<Color> blueAndWhite = EnumSet.of(Color.BLUE, Color.WHITE);
        }

    // 장점 4 : 리턴하는 객체의 클래스가 입력 매개변수에 따라 매번 다를 수 있다.
    static class BarFoo extends Foo {

    }

    enum Color {
        RED, BLUE, WHITE
    }

    // private static 필요한 경우 : 게임을 하고 잔다는 메소드는 밖으로 노출될 필요 없음.
    // public static 이면 private static 만 호출할 수 있음
    public static void doSomething() {
        // TODO 청소를 한다.
        // TODO 애들이랑 놀아준다.
        // TODO 저녁 약속에 간다.
        게임을하고잔다();
    }

    public static void doSomethingTomorrow() {
        // TODO 애들 데리고 수영장에 간다.
        // TODO 밥을 먹는다.
        게임을하고잔다();
    }

    private static void 게임을하고잔다() {
        // TODO 게임을 한다.
        // TODO 잔다.
    }
}
