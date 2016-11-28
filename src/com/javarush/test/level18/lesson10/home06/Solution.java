package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Byte,Integer> map = new TreeMap<>();

        FileInputStream fileReader = new FileInputStream(args[0]);
        byte[] buffer = new byte[fileReader.available()];
        fileReader.close();

        for (byte b: buffer){
            map.put(b,1);
        }

        for (byte bMap: map.keySet()){
            int count = 0;
            for (byte b: buffer){
                if(bMap == b){
                    count++;
                }
            }
            map.put(bMap,count);
        }

        for (Map.Entry c: map.entrySet()){
            System.out.println(c.getKey() + " " + c.getValue());
        }
    }
}
