package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human son1 = new Human("son1",true,10,new ArrayList<Human>());
        Human son2 = new Human("son2",true,10,new ArrayList<Human>());
        Human son3 = new Human("son3",true,10,new ArrayList<Human>());
        ArrayList<Human> children = new ArrayList<Human>();
        children.add(son1);
        children.add(son2);
        children.add(son3);

        Human mother = new Human("mother",false,40,children);
        Human dad = new Human("dad",true,40,children);

        ArrayList<Human> parents1 = new ArrayList<Human>();
        parents1.add(mother);

        ArrayList<Human> parents2 = new ArrayList<Human>();
        parents2.add(dad);

        Human grandmother1 = new Human("grandmother1",false,80,parents1);
        Human granddad1 = new Human("granddad1",true,80,parents1);

        Human grandmother2 = new Human("grandmother2",false,80,parents2);
        Human granddad2 = new Human("granddad2",true,80,parents2);

        System.out.println(granddad1);
        System.out.println(granddad2);

        System.out.println(grandmother1);
        System.out.println(grandmother2);

        System.out.println(dad);
        System.out.println(mother);
        
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(son2);

    }

    public static class Human
    {
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children;

        Human(String name,boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
