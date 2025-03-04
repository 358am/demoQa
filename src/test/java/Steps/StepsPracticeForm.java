package steps;


import pages.PracticeForm;

import static com.codeborne.selenide.Condition.*;
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
        practiceForm.firstName().setValue(name)
                .shouldHave(value(name));
    }
    // Заполнить поле Фамилия
    public void setValueFamily(String family) {
        practiceForm.lastName().setValue(family)
                .shouldHave(value(family));
    }
    // Заполнить поле Почта
    public void setValueEmail(String email) {
        practiceForm.email().setValue(email)
                .shouldHave(value(email));
    }
    // Выбрать радиокнопку гендер
    public void pickGender() {
        practiceForm.genderRadioMale();
    }
    // Указать номер мобильного телефона
    public void setMobNumber(String mobNumber) {
        practiceForm.mobNumber().setValue(mobNumber)
                .shouldHave(text(mobNumber));
    }

}
