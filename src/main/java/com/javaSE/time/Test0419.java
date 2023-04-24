package com.javaSE.time;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test0419 {
    public static void main(String[] args) throws ParseException {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        System.out.println("-1 = " + localDateTime.plusDays(-1));
        System.out.println(" 1 = " + localDateTime.plusDays(1));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;

        System.out.println();


    }
}
