package testsWithDataProviders.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class TestWithValueSource extends BaseTest {

    @ValueSource(strings = {"Суси и Гунканы", "Роллы", "Сеты"})
    @DisplayName("Тест с Дата Провайдером - ValueSourse")
    @ParameterizedTest(name = "Отображение заголовка при переходе в меню {0}")
    void SiteShouldHaveValuesInIngridients(String item) {
        open(baseUrl);
        $$(".menu-list__item").find(text(item)).click();
        $(".ajax_content h1").shouldHave(text(item));
    }
}
