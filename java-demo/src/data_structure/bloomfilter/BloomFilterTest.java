package data_structure.bloomfilter;

import java.util.HashSet;
import java.util.Random;

/**
 * 布隆过滤器测试
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-24 22:20
 */
public class BloomFilterTest {
    private final String[] URLS = {
            "http://www.csdn.net/",
            "http://www.baidu.com/",
            "http://www.google.com.hk",
            "http://www.cnblogs.com/",
            "http://www.zhihu.com/",
            "https://www.shiyanlou.com/",
            "http://www.google.com.hk",
            "https://www.shiyanlou.com/",
            "http://www.csdn.net/"
    };

    private void testBloomFilter() {
        BloomFilter bloomFilter = new BloomFilter();
        for (int i = 0; i < URLS.length; i++) {
            if (bloomFilter.contains(URLS[i])) {
                System.out.println("contains:" + URLS[i]);
                continue;
            }

            bloomFilter.add(URLS[i]);
            
        }
    }

    public static void main(String[] args) {
        BloomFilterTest test = new BloomFilterTest();
        test.testBloomFilter();
    }
}
