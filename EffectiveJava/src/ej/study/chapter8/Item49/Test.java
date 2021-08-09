package ej.study.chapter8.Item49;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test {


    public static void main(String[] args) {
        List foo = new ArrayList();
        foo.add("a");
        foo.add("b");
        foo.add("c");

        String str = "abcdjeiewiwejrlkjqwe";
        int result = Objects.checkIndex(6, 10);
        System.out.println(result);
    }
}
