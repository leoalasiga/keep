package basic.demo2.demo2_1;

/**
 * @author ljj
 * @description this program displays a greeting for the reader
 * @date 2020-07-08
 */
public class Welcome {
    public static void main(String[] args) {
        String greeting = "Welcome to Core java";
        System.out.println(greeting);

        for (int i = 0; i < greeting.length(); i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
