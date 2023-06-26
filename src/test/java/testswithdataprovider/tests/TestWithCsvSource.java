package testswithdataprovider.tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;


public class TestWithCsvSource extends BaseTest {

    @CsvSource(value = {
            "Суси и Гунканы, Суси и Гунканы",
            "Сасими, Сасими",
            "Роллы, Роллы"
    })
    @DisplayName("Тест с Дата Провайдером - scvSourse")
    @ParameterizedTest(name = "Отображение загаловка {1} при переходе в меню по {0}")
    void siteShouldHaveValuesInCatalog(String catalogName, String products) {
        open(baseUrl);
        $$(".menu-list__item").find(text(catalogName)).click();
        $(".ajax_content h1").shouldHave(text(products));






    }
}
