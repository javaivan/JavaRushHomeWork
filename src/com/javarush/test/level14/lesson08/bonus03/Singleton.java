package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by osven on 16.09.2015.
 */
/**
 * Created by osven on 15.09.2015.
 */
public class Singleton
{

    private static Singleton instance = null;

    // private constructor
    private Singleton()
    {
    }

    public static Singleton getInstance()
    {
        if (instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }
}