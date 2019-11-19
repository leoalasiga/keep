package sort;

/**
 * 希尔排序
 *
 * 先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；然后，取第二个增量d2
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-18 21:04
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };

        System.out.println("Before sort:");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }

        //shell sort
        int d = a.length;
        while (true) {
            d = d / 2;
            for (int i = 0; i < d; i++) {
                for (int j = i+d; j < a.length; j=j+d) {
                    int temp = a[j];
                    int k;
                    for (k = j - d; k >= 0 && a[k] > temp; k = k - d) {
                        a[k + d] = a[k];
                    }

                    a[k + d] = temp;
                    
                }
            }
            if (d == 1) {
                break;
            }
        }

        System.out.println();
        System.out.println("After sort");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }

    }
}
