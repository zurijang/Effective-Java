package ej.study;

import ej.study.chapter7.Item47.PowerSet;
import sun.java2d.loops.ProcessPath;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        HashSet<String> hs = new HashSet();
        hs.add("a");
        hs.add("b");
        hs.add("c");

        PowerSet ps = new PowerSet();
        System.out.println(ps.of(hs).size());
        System.out.println(ps.of(hs));

    }
}
