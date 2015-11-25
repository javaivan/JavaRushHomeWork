package com.javarush.test.level02.lesson08.task04;

/* Минимум четырех чисел
Написать функцию, которая вычисляет минимум из четырёх чисел.
Использовать функцию из задачи 1.
*/
public class Solution
{
    public static int min(int a, int b, int c, int d)
    {
	    int m2 = min(a,b);
	    int m3 = min(c,d);
	    if(m2 > m3)
		    return m3;
	    else
	        return m2;


    }

    public static int min(int a, int b)
    {
	    int m = 0;
	    if (a<b)
		    m = a;
	    else
		    m = b;
	    return m;

    }
}