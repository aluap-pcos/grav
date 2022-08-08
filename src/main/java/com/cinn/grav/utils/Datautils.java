package com.cinn.grav.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Datautils {
    public static LocalDateTime convertDateTime(String data){
        return LocalDateTime.of(Integer.parseInt(data.substring(0,1)), Integer.parseInt(data.substring(3,4)),
                Integer.parseInt(data.substring(5,8)), Integer.parseInt(data.substring(10,11)), Integer.parseInt(data.substring(12,13)));
    }

    public static LocalDate convertDate(String data){
        return LocalDate.of(Integer.parseInt(data.substring(0,1)), Integer.parseInt(data.substring(3,4)),
                Integer.parseInt(data.substring(5,8)));
    }
}
