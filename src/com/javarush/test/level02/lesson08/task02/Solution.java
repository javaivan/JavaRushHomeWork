package com.javarush.test.level02.lesson08.task02;

/* Максимум двух чисел
Написать функцию, которая вычисляет максимум из двух чисел.
*/
public class Solution
{
    public static int max(int a, int b)
    {
	    if(a > b){
		    return a;
	    }else{
		    return b;
	    }

    }
}