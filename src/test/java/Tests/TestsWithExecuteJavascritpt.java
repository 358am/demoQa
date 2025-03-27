package Tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.PracticeForm;
import steps.StepsPracticeForm;

import java.util.HashMap;
import java.util.Map;

import static Tests.GetTableContent.getTableContentWithExecuteScript;
import static org.assertj.core.api.Java6Assertions.assertThat;


@ExtendWith(SelenoidExtension.class)
public class TestsWithExecuteJavascritpt {
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
     **/

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

        // Создаем мапу с актуальными данными в таблице
        Map<String, String> actualData = getTableContentWithExecuteScript();
        // Сравниваем актуальные данные и ожидаемые
        assertThat(actualData).isEqualTo(expectedData);

    }
}
