package basic.demo4.demo4_1;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @author ljj
 * @description
 * @date 2020-08-06
 */
public class CalendarTest {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        //set to start of month
        //minusDays method make the date to previous days before
        date = date.minusDays(today - 1);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        //1=Monday....7=Sunday
        int value = dayOfWeek.getValue();

        System.out.println("Mon\tTue\tWed\tThu\tFri\tSat\tSun");
        for (int i = 1; i < value; i++) {
            System.out.print("\t");
        }

        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            }else{
                System.out.print(" ");
            }

            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }

        }

        if (date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }

    }
}
