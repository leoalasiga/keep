package data_structure.map;

import java.util.*;

/**
 * @ClassName MapDemo3
 * @Description map的排序
 *
 * @Author 刘嘉杰
 * @Date 2019/10/23 10:23
 * @Version 1.0
 */
public class MapDemo3 {
    public static void main(String[] args) {
        //mapSortByKey();
//        treeSort();
        mapSortByValue();
    }

    /**
     * TreeMap默认按key进行升序排序，如果想改变默认的顺序，可以使用比较器:
     */
    private static void treeSort() {
        Map<String,String> map = new TreeMap<String,String>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        map.put("b", "b");
        map.put("a", "c");
        map.put("c", "a");
        for (String key : map.keySet()) {
            System.out.println(key + " ：" + map.get(key));
        }
    }

    /**
     * map的排序,按照key排序
     */
    private static void mapSortByKey() {
        Map<String, String> map = new HashMap(3);
        map.put("b", "b");
        map.put("c", "c");
        map.put("a", "a");

        //通过ArrayList的构造函数,将map.entrySet()转换为list
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (Map.Entry<String, String> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

    /**
     * map的排序,按照value排序
     */
    private static void mapSortByValue() {
        Map<String, String> map = new HashMap(4);
        map.put("b", "b");
        map.put("a", "c");
        map.put("c", "a");
        map.put("d", "b");

        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, String> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
