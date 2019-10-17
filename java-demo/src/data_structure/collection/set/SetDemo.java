package data_structure.collection.set;

import common.entity.Person;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
//        demo1();
//        demo2();
//        demo3();
//        demo4();
        demo5();
    }

    /**
     * demo1 说明了set集合不能存储相同的元素
     */
    public static void demo1() {
        Set set = new HashSet();

        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        //返回此set元素的数量
        System.out.println(set.size());
        //如果set中不含有这个元素返回true
        System.out.println(set.add("1"));
        //返回现在的元素数量
        System.out.println(set.size());
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next() + " ");
        }
    }

    /**
     * demo2说了set集合存储的对象的时候，对象需要重写equals和hashcode方法
     */
    public static void demo2() {
        Set set = new HashSet();
        set.add(new Person("leo", 18));
        set.add(new Person("leo", 18));
        set.add(new Person("jack", 19));
        set.add(new Person("lucy", 28));
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    /**
     * 说明了treeSet是按照自然排序的
     */
    public static void demo3() {
        Set set = new TreeSet();
        set.add("ccc");
        set.add("aaa");
        set.add("bbb");
        set.add("ddd");

        System.out.println(set);
    }


    /**
     * 说明了当对象实现Comparable接口的时候，按照对象的规则进行排序
     */
    public static void demo4() {
        Set set = new TreeSet();
        set.add(new Person("aa", 20, "male"));
        set.add(new Person("bb", 17, "female"));
        set.add(new Person("cc", 18, "male"));
        set.add(new Person("dd", 16, "female"));
        set.add(new Person("aa", 18, "male"));

        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            Person next = (Person) iterator.next();
            System.out.println(next);

        }
    }


    /**
     * 最重要
     * 说明了容器排序的顺序>排序接口
     */
    public static void demo5() {
        Set set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Person person1 = (Person) o1;
                Person person2 = (Person) o2;
                System.out.println(person1 + " compare to " + person2);

                if (person1.getAge() > person2.getAge()) {
                    return -1;
                }

                if (person1.getAge() < person2.getAge()) {
                    return 1;
                }


                return person1.getName().compareTo(person2.getName());
            }


        });

        set.add(new Person("aa", 20, "male"));
        set.add(new Person("bb", 17, "female"));
        set.add(new Person("cc", 18, "male"));
        set.add(new Person("dd", 16, "female"));
        set.add(new Person("aa", 18, "male"));


        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            Person next = (Person) iterator.next();
            System.out.println(next);
        }

    }


}
