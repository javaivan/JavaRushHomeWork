package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String newString = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = reader.readLine();
        String fileTwo = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileOne));
        String s;
        String[] stringSplit;
        while ((s = fileReader.readLine()) != null){
            stringSplit = s.split(" ");
            for (String i: stringSplit){
                newString += Math.round(Double.parseDouble(i)) + " ";
            }
        }
        fileReader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileTwo));
        writer.write(newString);
        writer.close();
    }
}
