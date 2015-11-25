package com.javarush.test.level08.lesson11.home09;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws ParseException
    {
        System.out.println(isDateOdd("JANUARY  2010"));
    }
    public static boolean isDateOdd(String mm_dd_yy) {
        DateFormat format = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Calendar cal = GregorianCalendar.getInstance();
        try {
            Date date = format.parse(mm_dd_yy);
            cal.setTime(date);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        if (cal.get(Calendar.DAY_OF_YEAR)%2!=0)
            return true;
        return false;
    }
}
