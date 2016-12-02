package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileOneName = args[0];
        String fileTwoName = args[1];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileOneName));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = fileReader.readLine()) != null){
            String[] split = line.split(" ");
            for (String s: split){
                if(s.length()>6){
                    stringBuilder.append(s).append(",");
                }
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileTwoName));
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
        bufferedWriter.write(stringBuilder.toString());
        fileReader.close();
        bufferedWriter.close();
    }
}
