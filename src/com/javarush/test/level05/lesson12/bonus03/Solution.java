package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    int maximum = -10000000;

	    int NumberN=Integer.parseInt(reader.readLine());
	    int[] array = new int[NumberN]  ;

	    for(int i=0;i<NumberN;i++){
		    array[i]=Integer.parseInt(reader.readLine());
	    }

	    for(int i=0;i<NumberN;i++){
		    if (array[i]>maximum)

			    maximum=array[i]   ;
	    }
	    System.out.println(maximum);
    }
}
