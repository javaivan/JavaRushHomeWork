package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line;
        HashMap<String, Double> map = new HashMap<>();
        Double valueMax = 0D;
        while ((line = fileReader.readLine()) != null) {
            String[] split = line.split(" ");
            String name = split[0];
            Double value = Double.parseDouble(split[1]);
            if(valueMax < value){
                valueMax = value;
            }
            if(map.containsKey(name)){
                map.put(name, map.get(name) + value);
            } else {
                map.put(name, value);
            }
        }
        fileReader.close();

        for (Map.Entry<String, Double> entry: map.entrySet()){
            if(valueMax == entry.getValue()){
                System.out.println(entry.getKey());
            }
        }
    }
}
