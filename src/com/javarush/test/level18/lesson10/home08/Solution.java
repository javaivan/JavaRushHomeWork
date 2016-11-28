package com.javarush.test.level18.lesson10.home08;

import sun.invoke.empty.Empty;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Set<String> filesName = new HashSet<>();
            while (true) {
                String line = reader.readLine();
                if (!line.equals("exit")) {
                    filesName.add(reader.readLine());
                } else {
                    break;
                }
            }
            reader.close();

            for (String s : filesName) {
                ReadThread readThread = new ReadThread(s);
                readThread.start();
                readThread.join();

            }
        } catch (Exception e){}

        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }
        public void run(){
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                HashMap<Integer,Integer> map = new HashMap<>();
                while (fileInputStream.available()>0){
                    int data = fileInputStream.read();
                    Integer integer = map.get(data);
                    integer++;
                    map.put(data,integer);
                }
                fileInputStream.close();

                int max = 0;
                int integer = 0;

                for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                    if(entry.getValue() >= max){
                        max = entry.getValue();
                        integer = entry.getKey();
                    }
                }
                resultMap.put(fileName, integer);
            } catch (Exception e) {}

        }
    }
}
