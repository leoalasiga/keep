package basic.demo9.demo9_2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ljj
 * @description This program use a set to print all unique words in System.in
 * @date 2020-08-26
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        long totalTime = 0;


        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Please input words,enter blank to quit");
            while (in.hasNext()) {
                String word = in.next();
                if (word.equals("")) {
                    break;
                }


                long callTime = System.currentTimeMillis();
                words.add(word);
                long endTime = System.currentTimeMillis();
                callTime =endTime = callTime;
                totalTime += callTime;
            }
        }

        Iterator<String> iter = words.iterator();

        for (int i = 1; i <= 20 && iter.hasNext(); i++) {

            System.out.println(iter.next());
        }

        System.out.println("...");
        System.out.println(words.size()+" distinct words."+totalTime+" milliseconds");
    }
}
