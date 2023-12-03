package Tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import steps.StepsPracticeForm;


public class Tests {

    private final StepsPracticeForm stepsPracticeForm = new StepsPracticeForm();

    /**
     * Регистрация с валидными данными
     * **/

    @BeforeEach
    public void login() {
        stepsPracticeForm.login();
    }

    @Test
    void positiveReg() {
        stepsPracticeForm.setValueName("Kekw");
        stepsPracticeForm.setValueFamily("Wert");
        stepsPracticeForm.setValueEmail("abcde@gmail.com");
    }
}
