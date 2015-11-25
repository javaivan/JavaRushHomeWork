package com.javarush.test.level06.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/* Нужно исправить программу, чтобы компилировалась и работала
Задача: Программа вводит два числа с клавиатуры и выводит их максимум в виде «Max is 25»
*/

public class Solution
{
    public static int max = 100;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        String max = "Max is ";
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        max += a > b ? a : b;

        System.out.println(max);
    }

}
