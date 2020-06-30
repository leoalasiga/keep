package test;

/**
 * TODO
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2020-03-31 19:51
 */
public class StringTest {
    public static int test(String word1, String word2) {
        int i = word2.indexOf(word1.charAt(0));
        for (int j = 0; j < word1.length(); j++) {
            if (i + j + 1 <= word2.length()) {
                if (word1.charAt(j) != word2.charAt(i + j)) {
                    return -1;
                }
            }else{
                if (word1.charAt(j) != word2.charAt(i + j-word2.length())) {
                    return -1;
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(test("abcd", "cdab"));
    }
}
