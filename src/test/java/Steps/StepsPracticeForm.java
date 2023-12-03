package steps;


import pages.PracticeForm;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

/**
 * Шаги формы Practice Form
 * **/

public class StepsPracticeForm {
    private static final PracticeForm practiceForm = new PracticeForm();



    // Открыть форму
    public void login() {
        open(practiceForm.URL);
        practiceForm.title().shouldBe(visible);
    }
    // Заполнить поле Имя
    public void setValueName(String name) {
        practiceForm.firstName().setValue(name);
        practiceForm.firstName().shouldHave(text(name));
    }
    // Заполнить поле Фамилия
    public void setValueFamily(String family) {
        practiceForm.lastName().setValue(family);
        practiceForm.firstName().shouldHave(text(family));
    }
    // Заполнить поле Емэйл
    public void setValueEmail(String email) {
        practiceForm.email().setValue(email);
        practiceForm.email().shouldHave(text(email));
    }



}
