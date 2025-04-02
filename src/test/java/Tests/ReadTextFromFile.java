package Tests;

import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;

// Метод для чтения данных из файла в формате строки
public class ReadTextFromFile {
    public static String readTextFromFile(String filePath) {
        String fileContent = null;
        try {
            fileContent = FileUtils.readFileToString(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileContent;
    }
}
