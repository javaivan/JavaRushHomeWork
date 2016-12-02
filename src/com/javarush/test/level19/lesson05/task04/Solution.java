package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        String fileOne = consoleReader.readLine();
        String fileTwo = consoleReader.readLine();
        consoleReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileOne));
        ArrayList<String> lines = new ArrayList<>();
        String line;
        while ((line = fileReader.readLine()) != null){
            lines.add(line.replace(".","!"));
        }
        fileReader.close();

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileTwo));
        for (String s: lines){
            fileWriter.write(s);
            fileWriter.newLine();
        }
        fileWriter.close();
    }
}
