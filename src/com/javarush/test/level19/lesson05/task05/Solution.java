package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = consoleReader.readLine();
        String fileTwo = consoleReader.readLine();
        consoleReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileOne));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileTwo));
        String line;
        while ((line = fileReader.readLine()) != null){
            fileWriter.write(line.replaceAll("(?U)[\\pP\\s]", ""));
        }
        fileReader.close();
        fileWriter.close();
    }
}
