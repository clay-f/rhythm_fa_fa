package com.f.java.base.util.time;

import java.time.*;

/**
 * 日期时间
 * <p>
 * 为时间添加时区
 */
public class ZoneTime {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");

        LocalDate localDate = LocalDate.of(2014, Month.MARCH, 18);
        System.out.println(localDate.atStartOfDay(zoneId));

        LocalDateTime localDateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 1);
        System.out.println(localDateTime.atZone(zoneId));

        Instant instant = Instant.now();
        System.out.println(instant.atZone(zoneId));
    }
}
