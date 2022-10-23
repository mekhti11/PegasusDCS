package com.hititcs.pegasusdcs.util;

import android.os.Build;

import com.hititcs.pegasusdcs.domain.model.DepartingFlight;

import java.text.DateFormatSymbols;
import java.util.Locale;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;
public class DateTimeUtils {

    private DateTimeUtils(){

    }

    public static String getDepArrTimes(DepartingFlight flightSummary) {
        String date = flightSummary.getDeparture().getLocalTime().substring(8, 10) + new DateFormatSymbols().getMonths()[Integer.parseInt(flightSummary.getDeparture().getLocalTime().substring(5, 7))-1].substring(0, 3);
        String depTime = flightSummary.getDeparture().getLocalTime().substring(11,16);
        String arrTime = flightSummary.getArrivalList().get(0).getLocalTime().substring(11,16);

        return date + " " + depTime + " - " + arrTime;
    }

    public static String normalizeZonedDateTime(String zoned) {
        String result = "";

        if(zoned == null || zoned.isEmpty()) {
            return result;
        }

        result = zoned.substring(0, 16).replace("T", " ");

        return result;
    }

    public static String getTimeFromZonedDateTime(String zoned) {
        String result = "";

        if(zoned == null || zoned.isEmpty()) {
            return result;
        }

        result = zoned.substring(zoned.indexOf('T') + 1).substring(0,5);

        return result;
    }

    public static String formatDateEnglishName(LocalDate localDate) {
        if (localDate == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return DateTimeFormatter.ofPattern("dd MMM YYYY")
                .withLocale(Locale.ENGLISH)
                .format(localDate);
        }
        return "";
    }

    public static String formatDateToRequestFormat(LocalDate localDate) {
        if (localDate == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return DateTimeFormatter.ofPattern("YYYY-MM-dd")
                .withLocale(Locale.ENGLISH)
                .format(localDate);
        }
        return "";
    }

    public static String formatDateToHourFormat(LocalDate localDate) {
        if (localDate == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return DateTimeFormatter.ofPattern("HH:MM")
                .withLocale(Locale.ENGLISH)
                .format(localDate);
        }
        return "";
    }
}
