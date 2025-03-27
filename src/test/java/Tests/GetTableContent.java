package Tests;

import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.util.Map;

import static Tests.ReadTextFromFile.readTextFromFile;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class GetTableContent {

    // Метод возвращает мапу с актуальными значениями таблицы
    public static Map<String, String> getTableContentWithExecuteScript() {
        //Скрипт из файла записываем в строку
        String jsCode = readTextFromFile("src/test/resources/javascript/get_table_date.js");
        //Селенидовский метод, выполняем скрипт
        String browserRespons = executeJavaScript(jsCode);
        //System.out.println("browserRespons:\n" + browserRespons);

        //Для дальнейшего использования jsona мапим его (jackson) и записываем в мапу
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> data = null;
        try {
            data = mapper.readValue(browserRespons, new TypeReference<Map<String, String>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(data);
        return data;
    }
}
