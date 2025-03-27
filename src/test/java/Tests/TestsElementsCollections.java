package Tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.PracticeForm;
import steps.StepsPracticeForm;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(SelenoidExtension.class)
public class TestsElementsCollections {

    public final StepsPracticeForm stepsPracticeForm = new StepsPracticeForm();
    PracticeForm practiceForm = new PracticeForm();
    GetLocalDate getLocalDate = new GetLocalDate();

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

        /**
         * Нужно проверить успешное сохранения, в моем случае это всплывашка с заголовком и ранее введенные значения в формате таблицы
         **/

        //Хэш мэп, для хранения ожидаемых значений в таблице
        Map<String, String> expectedData = new HashMap<String, String>() {{
            put("Student Name", name + " " + lastName);
            put("Mobile", mobNumber);
            put("Student Email", "");
            put("Gender", "Male");
            put("Date of Birth", getLocalDate.getDate());
            put("Subjects", "");
            put("Hobbies", "");
            put("Picture", "");
            put("Address", "");
            put("State and City", "");

        }};

        //Объект класса СофтАсерт, поможет проверить всю коллекцию, даже если не все тесты зеленые
        SoftAssertions softAssertions = new SoftAssertions();

        //Ищем таблицу значений
        ElementsCollection table = Selenide.$$(".table-responsive tbody tr").snapshot();
        if (!table.isEmpty()) {
            for (SelenideElement tableElement : table) {
                String key = tableElement.$("td").text();
                String expectedValue = expectedData.get(key);

                String actualValue = tableElement.$("td", 1).text();
                //Сравниваем значения из коллекции со значениеим из мапы
                softAssertions.assertThat(actualValue)
                        .as("Result in tableElement %s was %s, but expected %s", key, actualValue, expectedValue)
                        .isEqualTo(expectedValue);
            }
            softAssertions.assertAll();
        }
    }

}
