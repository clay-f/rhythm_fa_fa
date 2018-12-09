package com.f.java.base.util.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

/**
 * 日期时间
 * <p>
 * 为时间添加时区
 */
public class ZoneTime {
    public static final ZoneId zoneId = ZoneId.of("Asia/Shanghai");

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(2014, Month.MARCH, 18);
        System.out.println(localDate.atStartOfDay(zoneId));

        LocalDateTime localDateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 1);
        System.out.println(localDateTime.atZone(zoneId));

        Instant instant = Instant.now();
        System.out.println(instant.atZone(zoneId));
    }


    public void instantAndLocalDateTimeConvertEachOther() {
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 1);
        dateTime.toInstant(ZoneOffset.of("Asia/Shanghai"));

        Instant instant = Instant.now();
        LocalDateTime.ofInstant(instant, zoneId);
    }

    public void customerTimeFormatter() {
        DateTimeFormatter formatterBuilder = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(".")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.CHINA);
    }

    public void zonedOffset() {
        LocalDateTime localDateTime = LocalDateTime.now();
        OffsetDateTime dateTime = OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(8));
    }
}
