package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Форма Practice Form
 * **/

public class PracticeForm {

    public String URL = "https://demoqa.com/automation-practice-form";

    public SelenideElement title() {
        return $x("//div/header/a/img")
                .as("Заголовок");
    }
    public SelenideElement url() {
        return $x(URL)
                .as("Форма для тестирования");
    }
    public SelenideElement firstName() {
        return $x("//input[@id=('firstName')]")
                .as("Имя");
    }
    public SelenideElement lastName() {
        return $x("//input[@id=('lastName')]")
                .as("Фамилия");
    }
    public SelenideElement email() {
        return $x("//input[@id=('userEmail')]")
                .as("Почта");
    }
    public SelenideElement genderRadioMale() {
        return $x("//input[@id=('gender-radio-1')]")
                .as("Гендер");
    }
    public SelenideElement genderRadioFemale() {
        return $x("//input[@id=('gender-radio-2')]")
                .as("Гендер");
    }
    public SelenideElement genderRadioOther() {
        return $x("//input[@id=('gender-radio-3')]")
                .as("Гендер");
    }
    public SelenideElement mobNumber() {
        return $x("//*[@id=\"userNumber\"]")
                .as("Номер телефона");
    }
    public SelenideElement dateBirth() {
        return $x("//input[@id=('dateOfBirthInput')]")
                .as("Дата рождения");
    }
    public SelenideElement subjectContainer() {
        return $x("//input[@id=('subjectsContainer')]")
                .as("Текстовое поле сабж");
    }

    public SelenideElement checkboxReading() {
        return $x("//input[@id=('hobbies-checkbox-2')]")
                .as("Чекбокс чтение");
    }
    public SelenideElement checkboxSport() {
        return $x("//input[@id=('hobbies-checkbox-1')]")
                .as("Чекбокс спорт");
    }
    public SelenideElement checkboxMusic() {
        return $x("//input[@id=('hobbies-checkbox-3')]")
                .as("Чекбокс музыка");
    }
    public SelenideElement adress() {
        return $x("//div/textarea[@id=('currentAddress')]")
                .as("Адрес");
    }
    public SelenideElement state() {
        return $x("//*[@id='state']")
                .as("Штат");
    }
    public SelenideElement city() {
        return $x("//div[@id='city']")
                .as("Город");
    }
    public SelenideElement submit() {
        return $x("//button[@id=('submit')]")
                .as("Кнопка ");
    }
}
