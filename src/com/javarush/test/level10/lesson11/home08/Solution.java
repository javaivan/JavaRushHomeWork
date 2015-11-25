package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести на их экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {

	    ArrayList[] arrayLists = new ArrayList[10];
	    for (int i =0; i<arrayLists.length;i++){
		    arrayLists[i] = new ArrayList<String>();
		    for (int j = 0;j<arrayLists.length;j++){
			    arrayLists[i].add(i + " - " + j);
		    }
	    }

        return arrayLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}