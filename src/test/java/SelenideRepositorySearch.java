import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1600x900";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop () {
        //открыть сайт
        open("https://github.com/");
        //открыть поле поиска
        $("[class='search-input']").click();
        //ввести в поле поиска "selenide" и нажать Enter
        $("#query-builder-test").setValue("selenide").pressEnter();

        // найти первую ссылку в поисковой выдаче и кликнуть по ней
        //$(".prc-Link-Link-85e08").click();
        $$("[data-testid=results-list").first().$("a").click(); // найти первую ссылку в поисковой выдаче и кликнуть по ней
        // два варианта одного и того же, первый я сам додумался, второй чел показал

        //проверка (assert): заголовок selenide / elenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
}
