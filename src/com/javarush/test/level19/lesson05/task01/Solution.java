package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = reader.readLine();
        String fileTwo = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileOne);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);

        FileOutputStream outputStream = new FileOutputStream(fileTwo);
        for (int i = 0; i < bytes.length; i++) {
            if (i % 2 == 1) {
                outputStream.write(bytes[i]);
            }
        }
        inputStream.close();
        outputStream.close();
    }
}
