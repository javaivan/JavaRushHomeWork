package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            for (User u: users){
                bufferedWriter.write(u.getFirstName());
                bufferedWriter.newLine();
                bufferedWriter.write(u.getLastName());
                bufferedWriter.newLine();
                bufferedWriter.write(String.valueOf(u.getBirthDate().getTime()));
                bufferedWriter.newLine();
                bufferedWriter.write(String.valueOf(u.isMale()));
                bufferedWriter.newLine();
                bufferedWriter.write(String.valueOf(u.getCountry()));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            ArrayList<String> us = new ArrayList<>();
            while (bufferedReader.ready()){
                us.add(bufferedReader.readLine());
            }
            for (int i = 0; i < us.size(); i +=5){
                User user = new User();
                user.setFirstName(us.get(i));
                user.setLastName(us.get(i+1));
                user.setBirthDate(new Date(Long.parseLong(us.get(i+2))));
                user.setMale(Boolean.valueOf(us.get(i+3)));
                String country = us.get(i+4);
                User.Country country1 = null;
                if (country.equals("UKRAINE")){
                    country1 = User.Country.UKRAINE;
                } else if (country.equals("RUSSIA")){
                    country1 = User.Country.RUSSIA;
                } else if (country.equals("OTHER")){
                    country1 = User.Country.OTHER;
                }
                user.setCountry(country1);
                users.add(user);
            }
            bufferedReader.close();
        }
    }
}
