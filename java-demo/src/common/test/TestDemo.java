package common.test;

import java.util.stream.Stream;

public class TestDemo {
    public static void main(String[] args) {
        String[] a = new String[10];
        Stream.of(a).forEach(s-> System.out.println(s));
        System.out.println(a.length);
    }
}
