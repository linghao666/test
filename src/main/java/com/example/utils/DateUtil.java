package com.example.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class DateUtil {

//    public static void main(String[] args) {
//        LocalDateTime startDateTime = LocalDateTime.of(2024, 4, 28, 0, 0); // 开始日期
//        LocalDateTime endDateTime = LocalDateTime.of(2024, 5, 3, 0, 0); // 结束日期
//
//        List<LocalDate> datesBetween = getDatesBetween(startDateTime, endDateTime);
//
//        // 打印所有日期
//        for (LocalDate date : datesBetween) {
//            System.out.println(date);
//        }
//    }

    public static void main(String[] args) {
        LocalDateTime dateTime1 = LocalDateTime.of(2024, 5, 8, 0, 0); // 第一个日期时间
        LocalDateTime dateTime2 = LocalDateTime.of(2024, 5, 3, 0, 0); // 第二个日期时间

        long daysDifference = getDaysDifference(dateTime1, dateTime2); // 获取以天为单位的差值

        // 打印差值
        System.out.println("Days Difference: " + daysDifference);
    }


    //两个日期之间所有天数
    public static List<LocalDate> getDatesBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        List<LocalDate> datesBetween = new ArrayList<>();

        LocalDate currentDate = startDateTime.toLocalDate();
        LocalDate endDate = endDateTime.toLocalDate();

        while (!currentDate.isAfter(endDate)) {
            datesBetween.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }

        return datesBetween;
    }

    //日期差值
    public static long getDaysDifference(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        return ChronoUnit.DAYS.between(dateTime1.toLocalDate(), dateTime2.toLocalDate());
    }

    //使日期精确到日
    public static LocalDateTime truncateToDay(LocalDateTime dateTime) {
        return dateTime.toLocalDate().atStartOfDay();
    }
}
