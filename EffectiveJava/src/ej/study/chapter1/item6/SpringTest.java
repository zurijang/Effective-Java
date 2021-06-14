package ej.study.chapter1.item6;

public class SpringTest {
    public static void main(String[] args) {
        String name = new String("zuri");
        String name2 = new String("zuri");

        String name3 = "zuri";
        String name4 = "zuri";

        System.out.println(name == name2);
        System.out.println(name.equals(name2));

        System.out.println(name3 == name4);

        Boolean true1 = Boolean.valueOf("true");
        Boolean true2 = Boolean.valueOf("true");

        System.out.println(true1 == true2);
        System.out.println(true1 == Boolean.TRUE);
    }
}
