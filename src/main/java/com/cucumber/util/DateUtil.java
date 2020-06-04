package com.cucumber.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateUtil {

    public static String formatTime(LocalDateTime scheduledTime) {

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        return scheduledTime.format(formatter);
    }

}
