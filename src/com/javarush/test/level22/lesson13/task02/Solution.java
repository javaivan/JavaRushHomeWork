package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String fileNameOne = args[0];
        String fileNameTwo = args[1];
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileNameOne),"UTF-8"));
        List<String> lines = new ArrayList<>();
        while (fileReader.ready()){
            lines.add(fileReader.readLine());
        }
        fileReader.close();

        BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileNameTwo), "Windows-1251"));
        for (int i = 0; i < lines.size(); i++){
            fileWriter.write(lines.get(i));
            if(i != lines.size()-1){
                fileWriter.newLine();
            }
        }
        fileWriter.close();
    }
}
