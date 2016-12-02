package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Date;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = fileReader.readLine()) != null){
            String[] split = line.split(" ");
            int y = Integer.parseInt(split[split.length-1]);
            int m = Integer.parseInt(split[split.length-2]) - 1;
            int d = Integer.parseInt(split[split.length-3]);
            Date date = new GregorianCalendar(y, m, d).getTime();

            StringBuilder name = new StringBuilder();
            for (int i = 0; i < split.length-3; i++){
                name.append(split[i] + " ");
            }
            Person person = new Person(name.toString().trim(), date);
            PEOPLE.add(person);
        }
        fileReader.close();
    }

}
