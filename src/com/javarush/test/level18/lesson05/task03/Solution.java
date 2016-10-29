package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader   = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();

        FileInputStream inputStream     = new FileInputStream(file1);
        FileOutputStream outputStream1  = new FileOutputStream(file2);
        FileOutputStream outputStream2  = new FileOutputStream(file3);

        if(inputStream.available()>0){
            if(inputStream.available()%2==0){
                byte[] buffer1 = new byte[inputStream.available()/2];
                byte[] buffer2 = new byte[inputStream.available()/2];

                int count1 = inputStream.read(buffer1);
                int count2 = inputStream.read(buffer2);

                outputStream1.write(buffer1, 0, count1);
                outputStream2.write(buffer2, 0, count2);
            } else {
                byte[] buffer1 = new byte[inputStream.available()/2+1];
                byte[] buffer2 = new byte[inputStream.available()/2];

                int count1 = inputStream.read(buffer1);
                int count2 = inputStream.read(buffer2);

                outputStream1.write(buffer1, 0, count1);
                outputStream2.write(buffer2, 0, count2);
            }
        }
        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }
}
