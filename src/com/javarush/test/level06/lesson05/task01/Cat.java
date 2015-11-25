package com.javarush.test.level06.lesson05.task01;

/* Метод finalize класса Cat
В классе Cat создать метод protected void finalize() throws Throwable
*/

public class Cat
{
	public String name;
	public static void main(String[]args){

	}

	public Cat(String name){
		this.name = name;
	}

	@Override
	protected void finalize() throws Throwable
	{
		super.finalize();
		System.out.println(name);
	}
}
