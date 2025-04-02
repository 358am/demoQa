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
    // Выбрать радиокнопку гендер муж
    public void pickGender() {
        practiceForm.genderRadioMale().parent().click();
        practiceForm.genderRadioMale().shouldHave(value("Male"));
    }

    //Получить установленную дату рождения в виде строки
    public String getBd() {
        String bd =  practiceForm.dateBirthOnSavedForm().getText();
        return bd;
    }
    // Выбрать заданные число месяц год для поля дата рождения
    public void setBD() {
        clickDateBirth();
        setMonthFebruary();
        setYear();
        setNumberBd();
    }
    //Выбрать число дата рождения
    public void setNumberBd() {
        practiceForm.dateBirthNumber().click();
    }
    //Выбрать 1996 год в календаре дата рождения
    public void setYear() {
        practiceForm.dateBirthYearPicker().selectOption("1996");
    }
    // Выбрать февраль в календаре даты рождения
    public void setMonthFebruary() {
        practiceForm.dateBirthMonthPicker()
                .selectOption(1);
    }
    // Кликнуть по календарю дата рождения
    public void clickDateBirth() {
        practiceForm.dateBirth()
                .click();
    }
    // Указать номер мобильного телефона
    public void setMobNumber(String mobNumber) {
        practiceForm.mobNumber().setValue(mobNumber)
                .shouldHave(value(mobNumber));
    }
    //Нажать кнопку submit
    public void pickSubmit() {
        practiceForm.submit().scrollTo().click();
    }

    public void checkHeader() {
        practiceForm.ThanksFor().
                shouldBe(visible);
    }

}
