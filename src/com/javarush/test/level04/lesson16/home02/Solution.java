package com.javarush.test.level04.lesson16.home02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sA = reader.readLine();
        String sB = reader.readLine();
        String sC = reader.readLine();
        int iA = Integer.parseInt(sA);
        int iB = Integer.parseInt(sB);
        int iC = Integer.parseInt(sC);


        if((iA < iB &&iA >iC)||(iA > iB &&iA <iC)) {
            System.out.print(iA);
        }
        if((iB < iA &&iB >iC)||(iB > iA &&iB <iC)) {
            System.out.print(iB);
        }
        if((iC < iB &&iC >iA)||(iC > iB &&iC <iA)) {
            System.out.print(iC);
        }

        //Напишите тут ваш код
    }
}
