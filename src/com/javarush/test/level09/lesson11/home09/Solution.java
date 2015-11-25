package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
	    Map<String,Cat>map = new HashMap<String, Cat>();
	    map.put("Вася",new Cat("Кот"));
	    map.put("Миша",new Cat("Кот"));
	    map.put("Мурка",new Cat("Кот"));
	    map.put("Тузик",new Cat("Кот"));
	    map.put("Слон",new Cat("Кот"));
	    map.put("Царь",new Cat("Кот"));
	    map.put("Стол",new Cat("Кот"));
	    map.put("Стул",new Cat("Кот"));
	    map.put("Смок",new Cat("Кот"));
	    map.put("Мыш",new Cat("Кот"));
	    return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
	    return new HashSet<Cat>(map.values());
        //Напишите тут ваш код
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
