package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {



        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {

            String fileName = bufferedReader.readLine();
            Scanner scanner = new Scanner(new File(fileName));
            List<Integer> array = new ArrayList<Integer>();
            while(scanner.hasNextInt()){
                int i = scanner.nextInt();
                if((i%2)==0){
                    array.add(i);
                }
            }
            Collections.sort(array);
            for (int i = 0; i < array.size(); i++){
                System.out.println(array.get(i));
            }
            scanner.close();
        } catch (Exception e){

        }
    }
}
