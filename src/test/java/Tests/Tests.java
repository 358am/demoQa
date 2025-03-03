package Tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.PracticeForm;
import steps.StepsPracticeForm;


@ExtendWith(SelenoidExtension.class)
public class Tests {

    public final StepsPracticeForm stepsPracticeForm = new StepsPracticeForm();
    PracticeForm practiceForm = new PracticeForm();

    Faker faker = new Faker();
    String name = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
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
        stepsPracticeForm.setValueEmail(email);

    }
}
