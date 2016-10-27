package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        String crudParam = args[0];
        if(crudParam.equals("-c")){
            Person person = null;
            String sex = args[2];
            String name = args[1];
            Date birthDay = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3]);

            if (sex.equals("м")) person = Person.createMale(name, birthDay);
            if (sex.equals("ж")) person = Person.createFemale(name, birthDay);

            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }

        if(crudParam.equals("-u")){
            Person person = null;
            int id = Integer.parseInt(args[1]);
            String sex = args[3];
            String name = args[2];
            Date birthDay = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4]);

            if (sex.equals("м")) person = Person.createMale(name, birthDay);
            if (sex.equals("ж")) person = Person.createFemale(name, birthDay);

            allPeople.set(id, person);
        }

        if (crudParam.equals("-d")){
            int id = Integer.parseInt(args[1]);
            Person person = allPeople.get(id);
            person.setName(null);
            person.setSex(null);
            person.setBirthDay(null);
            allPeople.set(id, person);
        }

        if (crudParam.equals("-i")){
            int id = Integer.parseInt(args[1]);
            Person person = allPeople.get(id);
            String sex = null;
            String birthDay = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay());
            if (person.getSex().equals(Sex.MALE))  sex = "м";
            if (person.getSex().equals(Sex.FEMALE))  sex = "ж";

            System.out.println(person.getName() + " " + sex + " " + birthDay);
        }
    }
}
