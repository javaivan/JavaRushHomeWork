package com.javarush.test.level02.lesson08.task03;

/* Минимум трех чисел
Написать функцию, которая вычисляет минимум из трёх чисел.
*/
public class Solution
{
    public static int min(int a, int b, int c)
    {
	    int m = 0;
	    if (a < b && a < c)
		    m = a;
	    else if ( b < a && b < c)
		    m = b;
	    else if (c < a && c < b)
		    m = c;
	    return m;

    }
}