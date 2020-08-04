package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Description:
 * @Author: Mr.Yuan
 * @Date: 2020/2/21 11:05
 * @Version 1.0
 */
public class DateOfDayUtils {

    /**
     * 获取某年某月的第一天
     *
     * @param:@param year
     * @param:@param month
     * @return:String
     */
    public static String getFisrtDayOfMonth(int year, int month) {
        return LocalDate.of(year, month, 1).toString();
    }

    /**
     * 获取某月的最后一天
     *
     * @param:@param year
     * @param:@param month
     * @return:String
     */
    public static String getLastDayOfMonth(int year, int month) {
        return LocalDate.of(year, month, 1).plusMonths(1L).minusDays(1L).toString();
    }

    /**
     * 获取某月的最后一天,23:59:59
     *
     * @param:@param year
     * @param:@param month
     * @return:String
     */
    public static LocalDateTime getLastDayDateOfMonth(int year, int month) {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(year, month, 1).plusMonths(1L).minusDays(1L), LocalTime.MAX);
        return localDateTime;
    }

    /**
     * 获取某月的最后一天,00:00:00
     *
     * @param:@param year
     * @param:@param month
     * @return:String
     */
    public static LocalDateTime getLastDayDateOfMonthMin(int year, int month) {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(year, month, 1).plusMonths(1L).minusDays(1L), LocalTime.MIDNIGHT);
        return localDateTime;
    }
    /**
     * 获取某月的第一天
     *
     * @param:@param year
     * @param:@param month
     * @return:String
     */
    public static LocalDateTime getFirstDayDateOfMonth(int year, int month) {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(year, month, 1), LocalTime.MIN);
        return localDateTime;
    }

    /**
     * 获取某月的一天最大时间
     *
     * @param:@param year
     * @param:@param ocalDateTime
     * @return:String
     */
    public static LocalDateTime getDayOfMaxTime(LocalDateTime localDateTime) {
        LocalDate localDate = localDateTime.toLocalDate();
        LocalDateTime maxTime = localDate.atTime(LocalTime.MAX);
        return maxTime;
    }

    /**
     * Date转LocalDate
     * @param date
     */
    public static LocalDate dateToLocalDate(Date date) {
        if(null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }



}
