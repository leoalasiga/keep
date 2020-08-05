package data_structure.bloomfilter;

import java.util.BitSet;

/**
 * 布隆过滤器
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-24 22:28
 */
public class BloomFilter {
    /**
     * BitSet初始分配2^24个bit
     */
    private static final int DEFAULT_SIZE = 1 << 25;

    /**
     * 不同hash函数的种子，一般应取质数
     */
    private static final int[] seeds = new int[]{5, 7, 11, 13, 31, 37, 61};

    private BitSet bitSet = new BitSet(DEFAULT_SIZE);
    /**
     * 哈希函数对象
     */
    private SimpleHash[] func = new SimpleHash[seeds.length];

    public BloomFilter() {
        for (int i = 0; i < seeds.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
        }
    }

    /**
     * 将字符串标记到bits中
     */
    public void add(String value) {
        for (SimpleHash f : func) {
            bitSet.set(f.hash(value),true);
        }
    }

    /**
     * 判断字符串是否已经被bits标记
     */
    public boolean contains(String value) {
        if (value == null) {
            return false;
        }

        boolean ret = true;
        for (SimpleHash f : func) {
            ret = ret && bitSet.get(f.hash(value));
        }

        return ret;
    }





    /**
     * hash函数类
     */
    static class SimpleHash {
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(String value) {
            int result = 0;
            int length = value.length();

            for (int i = 0; i < length; i++) {
                result = seed * result + value.charAt(i);
            }

            return (cap-1)&result;
        }
    }

}

