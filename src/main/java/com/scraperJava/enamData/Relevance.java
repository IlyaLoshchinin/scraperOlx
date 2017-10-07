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
    //For Olx.ua
    TODAY(LocalDate.now(ZoneId.of("Europe/Kiev")).format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));



    String localDate;
    Relevance(String date) {
        localDate = date.toLowerCase();
    }

    @Override
    public String toString() {
        return localDate;
    }

    public String setDate(){
        return null;
    };
}
