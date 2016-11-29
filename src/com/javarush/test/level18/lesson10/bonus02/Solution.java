package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        String id = correctLength(getId(fileName), 8);
        String productName = correctLength(args[1], 30);
        String price = correctLength(args[2],8);
        String quantity = correctLength(args[3], 4);


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
        bufferedWriter.write(id + productName + price + quantity);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    private static String getId(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        long id = 0L;
        String line;
        while ((line=bufferedReader.readLine()) != null){
            long i = Long.parseLong(line.substring(0,8).trim());
            if(i > id){
                id = i;
            }
        }

        bufferedReader.close();
        return id + 1 + "";
    }

    private static String correctLength(String s, int length){
        if(s.length() < length){
            return String.format("%1$-" + length + "s", s);
        } else {
            return s.substring(0,length);
        }
    }

}
