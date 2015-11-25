package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Date date = new Date(reader.readLine());
        System.out.println(newDate(date).toUpperCase());
    }

    public static String newDate(Date mm_dd_yy) {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMM d, yyyy");
        String date = DATE_FORMAT.format(mm_dd_yy);
        return date;
    }

}
