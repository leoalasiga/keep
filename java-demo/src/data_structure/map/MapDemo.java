package data_structure.map;

import java.util.*;

/**
 * @ClassName MapDemo
 * @Description 比较不同map的读取和插入速度
 * @Author 刘嘉杰
 * @Date 2019/10/17 14:45
 * @Version 1.0
 */
public class MapDemo {
    static int hashMapR = 0;
    static int hashMapW = 0;
    static int linkMapR = 0;
    static int linkMapW = 0;
    static int treeMapR = 0;
    static int treeMapW = 0;
    static int hashTableR = 0;
    static int hashTableW = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            test1(100 * 10000);
            System.out.println();
        }

        System.out.println("hashMapW = " + hashMapW / 10);
        System.out.println("hashMapR = " + hashMapR / 10);
        System.out.println("linkMapW = " + linkMapW / 10);
        System.out.println("linkMapR = " + linkMapR / 10);
        System.out.println("treeMapW = " + treeMapW / 10);
        System.out.println("treeMapR = " + treeMapR / 10);
        System.out.println("hashTableW = " + hashTableW / 10);
        System.out.println("hashTableR = " + hashTableR / 10);

    }


    public static void test1(int size) {
        int index;
        Random random = new Random();
        String[] key = new String[size];

        //HashMap插入
        Map<String, String> map = new HashMap<>();
        long start = System.currentTimeMillis();
        write(map,size,key);

        long end = System.currentTimeMillis();
        hashMapW += (end - start);
        System.out.println("HashMap插入耗时 = " + (end - start) + " ms");

        //HashMap读取
        start = System.currentTimeMillis();
        read(map,random,size,key);
        end = System.currentTimeMillis();
        hashMapR += (end - start);
        System.out.println("HashMap读取耗时 = " + (end - start) + " ms");

        //LinkedHashMap插入
        Map<String, String> linkMap = new LinkedHashMap<>();
        start = System.currentTimeMillis();

        write(linkMap,size,key);
        end = System.currentTimeMillis();
        linkMapW += (end - start);
        System.out.println("LinkedHashMap插入耗时 = " + (end - start) + " ms");

        //LinkedHashMap读取
        start = System.currentTimeMillis();
        read(linkMap, random, size, key);
        end = System.currentTimeMillis();
        linkMapR += (end - start);
        System.out.println("LinkedHashMap读取耗时 = " + (end - start) + " ms");

        //TreeMap插入
        Map<String, String> treeMap = new TreeMap<>();
        start = System.currentTimeMillis();

        write(treeMap,size,key);
        end = System.currentTimeMillis();
        treeMapW += (end - start);
        System.out.println("TreeMap插入耗时 = " + (end - start) + " ms");

        //TreeMap读取
        start = System.currentTimeMillis();
        read(treeMap, random, size, key);
        end = System.currentTimeMillis();
        treeMapR += (end - start);
        System.out.println("TreeMap读取耗时 = " + (end - start) + " ms");


        //Hashtable插入
        Map<String, String> hashTable = new Hashtable<>();
        start = System.currentTimeMillis();

        write(hashTable,size,key);
        end = System.currentTimeMillis();
        hashTableW += (end - start);
        System.out.println("Hashtable插入耗时 = " + (end - start) + " ms");

        //Hashtable读取
        start = System.currentTimeMillis();
        read(hashTable, random, size, key);
        end = System.currentTimeMillis();
        hashTableR += (end - start);
        System.out.println("Hashtable读取耗时 = " + (end - start) + " ms");

    }

    public static void write(Map map, int size, String[] key) {
        for (int i = 0; i < size; i++) {
            key[i] = UUID.randomUUID().toString();
            map.put(key[i], UUID.randomUUID().toString());
        }
    }

    public static void read(Map map,Random random ,int size, String[] key) {
        int index;
        for (int i = 0; i < size; i++) {
            index = random.nextInt(size);
            map.get(key[index]);
        }
    }
}
