package testsWithDataProviders.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://yakitoriya.ru/";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }
}
