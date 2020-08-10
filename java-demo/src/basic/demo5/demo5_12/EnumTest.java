package basic.demo5.demo5_12;

import java.util.Scanner;

/**
 * @author ljj
 * @description This program demonstrates enumerated types
 * @date 2020-08-10
 */
public class EnumTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a size:(SMALL,MEDIUM,LARGE,EXTRA_LARGE)");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("Size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());

        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job--you paid attention to the _.");
        }


    }
}
