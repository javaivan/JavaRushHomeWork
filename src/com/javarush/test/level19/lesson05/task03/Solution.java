package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = consoleReader.readLine();
        String fileTwo = consoleReader.readLine();
        consoleReader.close();

        BufferedReader fileOneReader = new BufferedReader(new FileReader(fileOne));

        ArrayList<Integer> list = new ArrayList<>();
        String line;
        while ((line = fileOneReader.readLine()) != null){
            for (String s: line.split(" ")){
                try {
                    Integer i = Integer.parseInt(s);
                    list.add(i);
                } catch (NumberFormatException e){
                    //ok}
                }
            }
        }
        BufferedWriter fileTwoWriter = new BufferedWriter(new FileWriter(fileTwo));
        for (Integer i: list){
            fileTwoWriter.write(i + " ");
        }
        fileOneReader.close();
        fileTwoWriter.close();

    }
}
