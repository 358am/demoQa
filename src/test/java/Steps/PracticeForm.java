package steps;

import any.Selectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Шаги формы Practice Form
 * **/

public class PracticeForm {
    private static final Selectors Selectors = new Selectors();



    // Открыть форму
    public void login() {
        open(Selectors.url);
    }
    // Заполнить поле Имя
    public void setValueName(String name) {
        $(Selectors.firstName().setValue(name));
        $(Selectors.firstName().shouldHave(text(name)));
    }
    // Заполнить поле Фамилия
    public void setValueFamily(String family) {
        $(Selectors.lastName().setValue(family));
        $(Selectors.firstName().shouldHave(text(family)));
    }
    // Заполнить поле Емэйл
    public void setValueEmail(String email) {
        $(Selectors.email().setValue(email));
        $(Selectors.email().shouldHave(text(email)));
    }



}
