package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
		int[] array = new int[5];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = Integer.parseInt(reader.readLine());
		}

		sort(array);

		for (int x : array)
		{
			System.out.println(x);
		}
	}

	public static void sort(int[] array)
	{
		for (int i = 0; i < array.length; i++) {
			int min = array[i];
			int imin = i;
			for (int j = i+1; j < array.length; j++) {
				if (array[j] < min) {
					min = array[j];
					imin = j;
				}
			}
			if (i != imin) {
				int temp = array[i];
				array[i] = array[imin];
				array[imin] = temp;
			}
		}
	}

}
