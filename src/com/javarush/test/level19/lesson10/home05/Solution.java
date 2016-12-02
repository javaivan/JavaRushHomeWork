package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileOneName = args[0];
        String fileTwoName = args[1];
        Pattern pattern = Pattern.compile("\\d");

        BufferedReader fileReader = new BufferedReader(new FileReader(fileOneName));
        BufferedWriter fileWrite = new BufferedWriter(new FileWriter(fileTwoName));
        String line;
        while ((line = fileReader.readLine()) != null){
            String[] split = line.split(" ");
            for (String s: split){
                if(pattern.matcher(s).find()){
                    fileWrite.write(s + " ");
                }
            }
        }
        fileReader.close();
        fileWrite.close();
    }
}
