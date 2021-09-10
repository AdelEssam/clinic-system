package com.stc.clinic.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperUtils {

    public static LocalDate StringToLocalDate(String date){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date,formatter);
    }
    public static String formatDate(LocalDate date){
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }


}
