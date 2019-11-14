package data_structure.bitset;

import java.util.BitSet;

/**
 * 计算素数
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-14 20:17
 */
public class ComputeSieve {
    public static void main(String[] args) {
        int n = 100;
        BitSet bitSet = new BitSet(n+1);
        int i;
        for (i = 2; i <= n; i++) {
            bitSet.set(i);
        }

        i=2;
        while (i * i <= n) {
            if (bitSet.get(i)) {
                int k = i * 2;
                while (k <= n) {
                    bitSet.clear(k);
                    k += i;
                }
            }
            i++;
        }

        i = 0;
        while (i <= n) {
            if (bitSet.get(i)) {
                System.out.println(i);

            }
            i++;
        }
    }

}
