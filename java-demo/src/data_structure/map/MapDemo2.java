package data_structure.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName MapDemo2
 * @Description 比较map遍历的快慢
 * @Author 刘嘉杰
 * @Date 2019/10/23 9:50
 * @Version 1.0
 */
public class MapDemo2 {
    static int foreach_keySet = 0;
    static int foreach_entrySet = 0;
    static int iterator_keySet = 0;
    static int iterator_entrySet = 0;

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000000; i++){
            map.put(i, i);
        }

        for (int i = 0; i < 10; i++) {
            testSpeed(map);
        }

        System.out.println("foreach_keySet = " + foreach_keySet / 10);
        System.out.println("foreach_entrySet = " + foreach_entrySet / 10);
        System.out.println("iterator_keySet = " + iterator_keySet / 10);
        System.out.println("iterator_entrySet = " + iterator_entrySet / 10);

    }

    private static void testSpeed(Map<Integer, Integer> map) {

        long start = System.currentTimeMillis();
        for (Integer integer : map.keySet()) {
            map.get(integer);
        }
        long end = System.currentTimeMillis();
        foreach_keySet += (end - start);
        System.out.println("增强for循环，keySet迭代 -> " + (end - start) + " ms");

         start = System.currentTimeMillis();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            integerIntegerEntry.getValue();
        }
         end = System.currentTimeMillis();
        foreach_entrySet += (end - start);
        System.out.println("增强for循环，entrySet迭代 -> " + (end - start) + " ms");


        start = System.currentTimeMillis();
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            map.get(iterator.next());
        }
        end = System.currentTimeMillis();
        iterator_keySet += (end - start);
        System.out.println("迭代器，keySet迭代 -> " + (end - start) + " ms");

        start = System.currentTimeMillis();
        Iterator<Map.Entry<Integer, Integer>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()) {
            iterator1.next().getValue();
        }
        end = System.currentTimeMillis();
        iterator_entrySet += (end - start);
        System.out.println("迭代器，entrySet迭代 -> " + (end - start) + " ms");

    }
}
