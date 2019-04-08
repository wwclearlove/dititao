package cdictv.tiyitao.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static String showYMD() {
        String data = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Calendar calendar = Calendar.getInstance();
        data = simpleDateFormat.format(calendar.getTime());
        return data;
    }

    public static String showD() {
        String data = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        Calendar calendar = Calendar.getInstance();
        data = simpleDateFormat.format(calendar.getTime());
        return data;
    }

    public static String showWeek() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        Calendar calendar = Calendar.getInstance();
        String data = simpleDateFormat.format(calendar.getTime());
        return data;
    }

    public static String showWeekafter(int d) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH + d);
        String data = simpleDateFormat.format(calendar.getTime());
        return data;
    }



    //Tyred
    public static String getDay(int i) {
        SimpleDateFormat df = new SimpleDateFormat("dd日");
        String format = df.format(new Date().getTime()+60000*60*24*i);
        return format;
    }
    public static String getWeek(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String week = sdf.format(date);
        return week;
    }public static String getWeek2(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String format = sdf.format(new Date().getTime()+60000*60*24*i);
        return format;
    }
}
