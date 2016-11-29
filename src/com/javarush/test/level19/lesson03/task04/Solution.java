package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner){
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            String firstName = arr[1];
            String middleName = arr[2];
            String lastName = arr[0];
            int year = Integer.parseInt(arr[5]);
            int month = Integer.parseInt(arr[4]) - 1;
            int day = Integer.parseInt(arr[3]);
            Calendar calendar = new GregorianCalendar(year, month, day);
            return new Person(firstName, middleName, lastName, calendar.getTime());
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
}
