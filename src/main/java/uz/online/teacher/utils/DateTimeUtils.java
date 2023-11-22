package uz.online.teacher.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class DateTimeUtils {

    public static Date toDate(String dateFormat, String stringDate) throws ParseException {
        if (StringUtils.isEmpty(stringDate))
            return null;
        return new SimpleDateFormat(dateFormat).parse(stringDate);
    }

    public static String dataToString(String stringFormat, Date date) {
        if (date == null)
            return null;
        return new SimpleDateFormat(stringFormat).format(date);
    }

    public static Instant toInstant(String dateFormat, String stringDate) throws ParseException {
        if (StringUtils.isEmpty(stringDate))
            return null;
        return new SimpleDateFormat(dateFormat).parse(stringDate).toInstant();
    }
    public static String instantToString(String stringFormat, Instant instant) {
        if (instant == null)
            return null;
        return new SimpleDateFormat(stringFormat).format(instant);
    }
}
