package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        int id = 1;
        String operator = args[0];
        if(operator.equals("-c")){
            if(args.length >= (id+2)) {
                addPerson(args, id);
            }
        }
        if(operator.equals("-u")){
            updatePerson(args, id);
        }
        if(operator.equals("-d")){
            deletePerson(args);
        }
        if(operator.equals("-i")){
            infoPerson(args);
        }
    }

    private synchronized static void addPerson(String[] args, int id) throws ParseException {
        if(args.length >= (id+2)){
            Person person = null;
            String sex = args[id+1];
            String name = args[id];
            Date birthDay = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[id+2]);

            if (sex.equals("м")) person = Person.createMale(name, birthDay);
            if (sex.equals("ж")) person = Person.createFemale(name, birthDay);
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
            if(args.length > (id+5)){
                addPerson(args,id+3);
            }
        }
    }
    private synchronized static void updatePerson(String[] args, int orderId) throws ParseException {
        if(args.length >= (orderId+3)) {
            Person person = null;
            int id = Integer.parseInt(args[orderId]);
            String sex = args[orderId+2];
            String name = args[orderId+1];
            Date birthDay = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[orderId+3]);
            if (sex.equals("м")) person = Person.createMale(name, birthDay);
            if (sex.equals("ж")) person = Person.createFemale(name, birthDay);
            allPeople.set(id, person);
            if(args.length >= (orderId+7)) {
                updatePerson(args,orderId);
            }
        }
    }
    private synchronized static void deletePerson(String[] args){
        for (int i = 1; i<args.length; i++){
            int id = Integer.parseInt(args[i]);
            if (id > allPeople.size() - 1) {
                break;
            }
            Person person = allPeople.get(id);
            person.setName(null);
            person.setSex(null);
            person.setBirthDay(null);
            allPeople.set(id, person);
        }
    }

    private synchronized static void infoPerson(String[] args){
        for (int i = 1; i<args.length; i++){
            int id = Integer.parseInt(args[i]);
            if (id > allPeople.size() - 1) {
                break;
            }
            Person person = allPeople.get(id);
            String sex = null;
            String birthDay = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay());
            if (person.getSex().equals(Sex.MALE))  sex = "м";
            if (person.getSex().equals(Sex.FEMALE))  sex = "ж";
            System.out.println(person.getName() + " " + sex + " " + birthDay);
        }
    }

}
