package ej.study.chapter4.item20;

import java.util.*;


public class Test extends AbstractMapEntry {
    public Test(Object key, Object value) {
        super(key, value);
    }

    // 골격 구현을 사용해 완성한 구체 클래스
    static List<Integer> intArrayAsList(int[] a) {
        Objects.requireNonNull(a);

        // 다이아몬드 연산자를 이렇게 사용하는건 자바 9부터 가능하다.
        // 더 낮은 버전을 사용한다면 <Integer>로 수정하자.
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int i) {
                return a[i]; // 오토박싱(아이템 6)
            }

            @Override
            public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val;     // 오토언박싱
                return oldVal;  // 오토박싱
            }

            @Override
            public int size() {
                return a.length;
            }

        };
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        List<Integer> listA = intArrayAsList(a);
        for(int i : listA) {
            System.out.print(i + " ");
        }
        System.out.println("");

        for (int i = listA.size(), j=0; j < listA.size(); i--, j++) {
            System.out.println("Get : " + listA.get(j) + " Set : " + i);
            listA.set(j, i);
        }

        for(int i : listA) {
            System.out.print(i + " ");
        }
        System.out.println("");

        Test test = new Test("effective", "java");
        System.out.println("Key :: " + test.getKey() + " Value :: " + test.getValue());
        System.out.println("equals :: " + test.equals(test));
        System.out.println("hashCode :: " + test.hashCode());
        System.out.println(test); // toString()
    }

}
