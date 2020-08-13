package basic.demo6.demo6_10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author ljj
 * @description This program demonstrates the use of proxies
 * @date 2020-08-13
 */
public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[100];

        //file the elements with the proxies for the integer 1 ... 100
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        //constructor a random integer
        Integer key = new Random().nextInt(elements.length) + 1;
        //search for the key
        int result = Arrays.binarySearch(elements, key);
        //print match if found
        if (result >= 0) {
            System.out.println(elements[result]);
        }


    }
}
