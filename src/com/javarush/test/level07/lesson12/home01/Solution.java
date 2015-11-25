package com.javarush.test.level07.lesson12.home01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Вывести числа в обратном порядке
Ввести с клавиатуры 10 чисел и заполнить ими список.
Используя цикл for вывести их в обратном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    int[] array = new int[10];
	    for (int i = 0; i<array.length;i++){
		    array[i] = Integer.parseInt(reader.readLine());
	    }


	    for (int i = 0; i < array.length;i++){
		    int j = array.length - i -1;
		    System.out.println(array[j]);
	    }
        //Напишите тут ваш код
    }
}
