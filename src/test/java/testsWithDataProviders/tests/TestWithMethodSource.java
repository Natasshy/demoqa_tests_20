package testsWithDataProviders.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


public class TestWithMethodSource extends BaseTest {

    static Stream <Arguments> SiteShouldHaveValues(){
        return Stream.of(
                Arguments.of("Сасими",List.of("Сякэ", "Магуро", "Унаги")),
                Arguments.of("Бенто-ланч",List.of("БЕНТО №1", "БЕНТО №2", "БЕНТО №3", "БЕНТО №4", "БЕНТО №5"))
        );
    }

    @MethodSource
    @DisplayName("Тест с Дата Провайдером - MethodSourse")
    @ParameterizedTest(name = "На странице категории должны отображаться продукты/товары: {1}")
    void SiteShouldHaveValuesInMenu(String catalogName,List<String> expectedButtons) {
        open(baseUrl);
        $$(".menu-list__item").findBy(text(catalogName)).click();
        $$(".catalog__title").should(texts(expectedButtons));


    }
}
