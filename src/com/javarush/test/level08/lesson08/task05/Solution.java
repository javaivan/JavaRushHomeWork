package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1Сталлоне", "Сталлоне");
        map.put("1Сталин", "Сталин");
        map.put("1Батистута", "Батистута");
        map.put("1Матиз", "Матиз");
        map.put("1Борис", "Борис");
        map.put("1Новел", "Новел");
        map.put("1Виолла", "Виолла");
        map.put("1Шокин", "Шокин");
        map.put("1Феликс", "1");
        map.put("1Эдмунд", "1");

        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> map2 = new HashMap<String, String>(map);
        HashMap<String, String> map3 = new HashMap<String, String>(map);
        for(Map.Entry<String, String> p : map2.entrySet()) {
            map3.remove(p.getKey());
            if(map3.containsValue(p.getValue())){
                removeItemFromMapByValue(map,p.getValue());
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
/*
    public static void main(String[] args)
    {
        HashMap<String, String> people = createMap();
        System.out.println(people);
        removeTheFirstNameDuplicates(people);
        System.out.println(people);


        for(Map.Entry<String, String> p : people.entrySet()) {
            System.out.println(p.getKey());
            System.out.println(p.getValue());
            System.out.println("-----");

            // do what you have to do here
            // In your case, an other loop.
        }

        System.out.println(people.containsValue("Эдмунд"));


    }*/

}
