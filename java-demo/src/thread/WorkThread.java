package thread;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A Thread implements Runnable
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-04 21:14
 */
public class WorkThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + getNowDate());

        //sleep 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " End. Time = " + getNowDate());
    }


    /**
     * get now time with format yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getNowDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowStr = dateTimeFormatter.format(now);
        return nowStr;
    }


}
