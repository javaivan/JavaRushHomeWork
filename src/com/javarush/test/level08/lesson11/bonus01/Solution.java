package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String monthName = reader.readLine();
        System.out.println(monthName + " is " + getMonthNumber(monthName) + " month");
    }

    public static int getMonthNumber(String month){
        Map<String, Integer>  monthNumber  = new HashMap<String, Integer>();
        monthNumber.put("January",1);
        monthNumber.put("February",2);
        monthNumber.put("March",3);
        monthNumber.put("April",4);
        monthNumber.put("May",5);
        monthNumber.put("June",6);
        monthNumber.put("July",7);
        monthNumber.put("August",8);
        monthNumber.put("September",9);
        monthNumber.put("October",10);
        monthNumber.put("November",11);
        monthNumber.put("December", 12);

        return monthNumber.get(month);
    }
}
