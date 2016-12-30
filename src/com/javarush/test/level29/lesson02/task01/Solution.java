package com.javarush.test.level29.lesson02.task01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/* Рефакторинг в соответствии с Naming and Code Convention
Исправить код в соответствии с Naming and Code Convention (Shift+F6 для рефакторинга)
Не оставлять комментариев, проверяется строгое соответствие стандарту

Подсказка: IDEA не умеет правильно переименовывать имена классов, если меняется только регист.
Переименуйте имя класса во вспомогательное имя, а мотом в это же в правильном регистре.
*/
public class Solution {
    public static final String defaultFileName = "C:/tmp/file_strange_name.tmp";

    private final String localFileName;
    private List<String> contentAslines;
    private boolean fileLoaded;

    public Solution(String firstFileName) {
        localFileName = firstFileName == null ? defaultFileName : firstFileName;
    }

    public boolean getFileLoaded() {
        return fileLoaded;
    }

    public void DownloadFileContent() {
        Path source = Paths.get(localFileName);

        try {
            contentAslines = Files.readAllLines(source, Charset.defaultCharset());
            fileLoaded = true;
        } catch (IOException e) {
            System.out.println("Unsuccessful. What a surprise!");
        }
    }

    public boolean isfileexpectedline(String expectedline) {
        return contentAslines.contains(expectedline);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String packageName = Solution.class.getPackage().getName().replaceAll("[.]", "\\\\");
        String fileName = "src\\" + packageName + "\\Solution.java";

        Solution solution = new Solution(fileName);
        solution.DownloadFileContent();
        if (solution.getFileLoaded()) {
            System.out.println(solution.isfileexpectedline("public class Solution {"));   //expected true
            System.out.println(solution.isfileexpectedline(" public class Solution {"));  //expected false
        }
    }
}
