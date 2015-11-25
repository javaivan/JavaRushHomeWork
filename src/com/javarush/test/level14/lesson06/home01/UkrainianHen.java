package com.javarush.test.level14.lesson06.home01;

/**
 * Created by osven on 12.09.2015.
 */
class UkrainianHen extends Hen{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 20;
    }
    public String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
