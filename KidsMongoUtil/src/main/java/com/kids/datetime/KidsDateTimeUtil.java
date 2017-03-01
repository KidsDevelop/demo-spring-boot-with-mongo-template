package com.kids.datetime;

import org.joda.time.LocalDateTime;

import java.util.Date;

public class KidsDateTimeUtil {

    public static LocalDateTime fromDateFields(Date date) {

        if(null == date)
            return null;
        else
            return LocalDateTime.fromDateFields(date);
    }

}
