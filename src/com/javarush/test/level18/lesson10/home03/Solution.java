package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();

        FileOutputStream outputStream = new FileOutputStream(file1);
        FileInputStream inputStream1 = new FileInputStream(file2);
        FileInputStream inputStream2 = new FileInputStream(file3);

        if(inputStream1.available()>0 && inputStream2.available() >0){
            byte[] buffer1 = new byte[inputStream1.available()];
            byte[] buffer2 = new byte[inputStream2.available()];

        }

    }
}
