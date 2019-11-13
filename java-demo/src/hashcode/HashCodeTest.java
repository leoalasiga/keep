package hashcode;

/**
 * TODO
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-06 20:31
 */
public class HashCodeTest {
    public static void main(String[] args) {
        int hash = 0;
        String s = "ok";
        StringBuilder stringBuilder = new StringBuilder(s);
        System.out.println(s.hashCode() + "  " + stringBuilder.hashCode());

        String t = new String("ok");
        StringBuilder tb = new StringBuilder(t);

        System.out.println(t.hashCode() + " " + tb.hashCode());

    }
}
