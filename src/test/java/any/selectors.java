package any;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class selectors {

    public SelenideElement url() {
        return $x("https://demoqa.com/automation-practice-form")
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
    public SelenideElement genderRadio() {
        return $x("//input[@id=('gender-radio-1')]")
                .as("Гендер");
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
