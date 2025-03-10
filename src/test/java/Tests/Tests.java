package Tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.PracticeForm;
import steps.StepsPracticeForm;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;


@ExtendWith(SelenoidExtension.class)
public class Tests {

    public final StepsPracticeForm stepsPracticeForm = new StepsPracticeForm();
    PracticeForm practiceForm = new PracticeForm();

    Faker faker = new Faker();
    String name = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String mobNumber = faker.numerify("##########");
    /**
     * Регистрация с валидными данными
     * **/

    @BeforeEach

    public void login() {
        stepsPracticeForm.login();
    }

    @Test
    void positiveReg() {
        stepsPracticeForm.setValueName(name);
        stepsPracticeForm.setValueFamily(lastName);
        //stepsPracticeForm.setValueEmail(email);
        stepsPracticeForm.pickGender();
        stepsPracticeForm.setMobNumber(mobNumber);
        stepsPracticeForm.pickSubmit();
        stepsPracticeForm.checkHeader();

        //Нужно проверить успешное сохранения, в моем случае это всплывашка с заголовком и ранее введенные значения в формате таблицы

        //Хэш мэп, для хранения ожидаемых значений в таблице
        Map<String, String> expectedData = new HashMap<String, String>(){{
            put("Name", name + " " + lastName);
            put("Mobile", mobNumber);
        }};

        //Ищем таблицу значений
        ElementsCollection table = $$(".table-responsive tbody tr").snapshot();
        if (!table.isEmpty()) {
        for (SelenideElement tableElement: table) {
            String key = tableElement.$("td").text();
            String expectedValue = expectedData.get(key);

            tableElement.$("td", 1).shouldHave(text(expectedValue));
        }
        }
    }
}
