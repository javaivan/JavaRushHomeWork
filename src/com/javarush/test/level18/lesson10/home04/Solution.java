package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = reader.readLine();
        String fileTwo = reader.readLine();
        reader.close();

        FileInputStream inputStreamOne = new FileInputStream(fileOne);
        byte[] bufferOne = new byte[inputStreamOne.available()];
        inputStreamOne.read(bufferOne);
        inputStreamOne.close();

        FileInputStream inputStreamTwo = new FileInputStream(fileTwo);
        byte[] bufferTwo = new byte[inputStreamTwo.available()];
        inputStreamTwo.read(bufferTwo);
        inputStreamTwo.close();

        FileOutputStream outputStream = new FileOutputStream(fileOne);
        outputStream.write(bufferTwo);
        outputStream.close();

        FileOutputStream outputStream1 = new FileOutputStream(fileOne, true);
        outputStream1.write(bufferOne);
        outputStream1.close();
    }
}
