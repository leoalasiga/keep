package collection;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2020-03-25 19:53
 */
public class ArraysDemo {
    public static void main(String[] args) {
        arraysAsListDemo1();
    }


    /**
     * 传递的数组必须是对象数组，而不是基本类型。
     */
    private static void arraysAsListDemo1() {
        int[] myArray = {1, 2, 3};
        List<int[]> ints = Arrays.asList(myArray);
        System.out.println(ints.size());
        System.out.println(ints.get(0));
//        System.out.println(ints.get(1));//会报错，越界
        int[] ints1 = ints.get(0);
        System.out.println(ints1[0]);

    }
}
