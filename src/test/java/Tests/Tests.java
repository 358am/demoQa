package Tests;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import steps.StepsPracticeForm;


public class Tests {

    private final StepsPracticeForm stepsPracticeForm = new StepsPracticeForm();

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
