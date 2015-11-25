package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
	public  static int arraySize = 20;
    public static void main(String[] args) throws Exception
    {
		int[] bigArray = new int[arraySize];
	    int[] firstArray = new int[arraySize/2];
	    int[] secondArray = new int[arraySize/2];
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    for (int i = 0 ; i< bigArray.length;i++){
		    bigArray[i]= Integer.parseInt(reader.readLine());

		    if(i<arraySize/2)
			    firstArray[i] = bigArray[i];
		    else
			    secondArray[i-arraySize/2] = bigArray[i];
	    }
	    for (int n : secondArray){
		    System.out.println(n);
	    }

    }
}
