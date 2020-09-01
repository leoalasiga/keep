package basic.demo8.demo8_2;

import basic.demo8.demo8_1.Pair;

import java.time.LocalDate;

/**
 * @author ljj
 * @description
 * @date 2020-08-25
 */
public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthdays = {
                LocalDate.of(1906,12,9),
                LocalDate.of(1815,12,10),
                LocalDate.of(1903,12,3),
                LocalDate.of(1910,6,22)
        };




        Pair<LocalDate> mm = ArrayAlg.minMax(birthdays);
        System.out.println("min="+mm.getFirst());
        System.out.println("max="+mm.getSecond());
    }
}
