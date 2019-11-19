package sort;

/**
 * 直接选择排序
 *
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-18 21:31
 */
public class DirectSelectSort {
    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
        System.out.println("Before sort:");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }

        //direct select sort
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            //min number's index
            int minIndex = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                }
                
            }

            a[minIndex] = a[i];
            a[i] = min;
        }


        System.out.println();
        System.out.println("After sort");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }
}
