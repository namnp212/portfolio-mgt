package com.namnp.portfolio_service.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtil {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private DateUtil(){}

    public static LocalDateTime getLocalDateTimeNowByTimeZone(ZoneId zoneId){
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime zonedMyTime = now.withZoneSameInstant(zoneId);
        return LocalDateTime.parse(zonedMyTime.format(formatter), formatter);
    }
}
