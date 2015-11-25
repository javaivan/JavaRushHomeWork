package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        public String firstName;
        public String lastName;
        public boolean sex;
        public int age;
        public String address;
        public String phone;

        public Human(String firstName){
            this.firstName = firstName;
        }
        public Human(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public Human(String firstName, String lastName, boolean sex){
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
        }
        public Human(String firstName, String lastName, int age){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
        public Human(String firstName, String lastName, String address){
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
        }
        public Human(String firstName, String lastName, boolean sex,String address){
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.address = address;
        }
        public Human(String firstName, String lastName, int age, String address){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.address = address;
        }
        public Human(String firstName, String lastName, String address, String phone){
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.phone = phone;
        }
        public Human(String firstName, String lastName, boolean sex, String address, String phone){
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.address = address;
            this.phone = phone;
        }
        public Human(String firstName, String lastName, int age, String address, String phone){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.address = address;
            this.phone = phone;
        }
    }
}
