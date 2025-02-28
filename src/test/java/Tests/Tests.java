package Tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import steps.StepsPracticeForm;


@ExtendWith(SelenoidExtension.class)
public class Tests {

    public final StepsPracticeForm stepsPracticeForm = new StepsPracticeForm();


    Faker faker = new Faker();
    /**
     * Регистрация с валидными данными
     * **/

    @BeforeEach

    public void login() {
        stepsPracticeForm.login();
    }

    @Test
    void positiveReg() {
        stepsPracticeForm.setValueName(faker.name().firstName());
        stepsPracticeForm.setValueFamily(faker.name().lastName());
        stepsPracticeForm.setValueEmail(faker.internet().emailAddress());
    }
}
