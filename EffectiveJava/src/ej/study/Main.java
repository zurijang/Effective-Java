package ej.study;

import ej.study.chapter7.Item47.Adapter;
import ej.study.chapter7.Item47.PowerSet;
import ej.study.chapter7.Item47.SubLists;

import java.util.*;
import java.util.stream.Stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
//        Stream<String> stream = Stream.of("aaa", "bbb", "ccc", "abc");
//
//        for (String str : Adapter.iterableOf(stream)){ // 반복이 불가능한 Stream을 iterable 로 변환시켜주는 iterableOf 사용
//            System.out.println(str);
//        }
//
//        System.out.println("------------------------------------\nPowerSet 멱집합 구하기");
//
//        // 커스텀 컬렉션 PowerSet 사용
//        HashSet<String> s = new HashSet<String>();
//        s.add("a");
//        s.add("b");
//        s.add("c");
//        s.add("d");
//
//        HashSet<String> s2 = new HashSet<String>();
//        s2.add("c");
//        s2.add("b");
//        s2.add("a");
//
//        System.out.println(PowerSet.of(s)); // s의 멱집합 요소 출력
//        System.out.println(PowerSet.of(s).size()); // s의 멱집합 개수
//        System.out.println(PowerSet.of(s).contains(s2)); // s2이 s에 포함되는 유무
//
//        System.out.println("-----------------------------\nSubList 사용하기");
//
//        // SubList
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//
//        for (int start = 0; start < list.size(); start++) {
//            for (int end = start + 1; end <= list.size(); end++) {
//                System.out.println(list.subList(start, end));
//            }
//        }
//
//        System.out.println("SubLists 사용해서 값 출력");
//
//        Stream src = SubLists.of(list); // prefixes 된 stream 형태
//        for(Object o : Adapter.iterableOf(src)) { // 출력을 위해 stream을 iterable로 변환
//            System.out.println(o);
//        }

        List<String> langs = Arrays.asList("java", "kotlin", "haskell", "ruby", "smalltalk", "java");
        System.out.println("list : " + langs);
        Set<String> langs_set = new HashSet<>(langs);
        System.out.println("set : " + langs_set);

        Stream<String> langs_stream = langs.stream();
        System.out.println(langs_stream.sorted());

        Stream<String> stream = Stream.of("aaa", "bbb", "ccc", "abc");

        for (String str : Adapter.iterableOf(stream)){ // 반복이 불가능한 Stream을 iterable 로 변환시켜주는 iterableOf 사용
            System.out.println(str);
        }

        System.out.println("------------------------------------\nPowerSet 멱집합 구하기");

        // 커스텀 컬렉션 PowerSet 사용
        HashSet<String> s = new HashSet<String>();
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("d");

        HashSet<String> s2 = new HashSet<String>();
        s2.add("c");
        s2.add("b");
        s2.add("a");

        System.out.println(PowerSet.of(s)); // s의 멱집합 요소 출력
        System.out.println(PowerSet.of(s).size()); // s의 멱집합 개수
        System.out.println(PowerSet.of(s).contains(s2)); // s2이 s에 포함되는 유무

        System.out.println("-----------------------------\nSubList 사용하기");

        // SubList
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for (int start = 0; start < list.size(); start++) { // stream 미사용
            for (int end = start + 1; end <= list.size(); end++) {
                System.out.println(list.subList(start, end));
            }
        }

        System.out.println("stream 형태 변환 출력");

        Stream src = SubLists.of(list); // prefixes 된 stream 형태
        for(Object o : Adapter.iterableOf(src)) { // 출력을 위해 stream을 iterable로 변환
            System.out.println(o);
        }

    }
}
