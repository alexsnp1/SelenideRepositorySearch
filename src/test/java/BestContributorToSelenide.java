import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
    @Test
    void andreiSolntsevShouldBeTheFirstContributor() {
        open("https://github.com/selenide/selenide");
        // находим плашку контрибюторы
        $("div.Layout-sidebar").$(byText("Contributors"))
                // возвращаемся выше по дереву и наводимся на первую li
                //.closest("div.BorderGrid-cell").$$("ul li").first().hover();
                .closest("h2").sibling(0).$$("li").first().hover();
        //проверка: во всплывающем окне есть текст Andrei Solntsev. (берем все поповеры и ищем первый видимый)
        // но можно было и просто написать в данном случае $(".popover").shouldhave(text""));
        $$(".Popover").findBy(visible).shouldHave(text("Andrei Solntsev"));


    }
}
