package com.scraperJava.enamData;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by Ilya Loshchinin on 23.09.2017.
 */

public enum Relevance {
    TODAY,
    YESTERDAY,
    THREEDAYS,
    WEEK;


    String localDate;
    Relevance() {
        ZoneId zoneId = ZoneId.of("Europe/Kiev");
        LocalDate nowDate = LocalDate.now(zoneId);
        DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        localDate = nowDate.minusDays(this.ordinal()).format(dtFormat).toLowerCase();
    }


    @Override
    public String toString() {
        return localDate;
    }


}
