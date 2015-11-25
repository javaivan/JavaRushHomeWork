package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
	public static void main(String[] args)
	{
		Man alex = new Man("Aleksandr", 18, "Moscow");
		Man nick = new Man("Nickolaj", 25, "Kiev");
		Woman klava = new Woman("Klavdia", 52, "Khacapetovka");
		Woman nastia = new Woman("Anastasia", 34, "Odessa");

		System.out.println(alex);
		System.out.println(nick);
		System.out.println(klava);
		System.out.println(nastia);
	}

	public static class Man {
		String name;
		int age;
		String address;

		public Man(String name, int age, String address) {
			this.name = name;
			this.age = age;
			this.address = address;
		}

		public String toString() {
			return name + " " + age + " " + address;
		}
	}

	public static class Woman {
		String name;
		int age;
		String address;

		public Woman(String name, int age, String address) {
			this.name = name;
			this.age = age;
			this.address = address;
		}

		public String toString() {
			return name + " " + age + " " + address;
		}
	}
}