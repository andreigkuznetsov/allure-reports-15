import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    public void issueSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").sendKeys("qa-guru/niffler");
        $("#query-builder-test").submit();

        $(linkText("qa-guru/niffler")).click();
        $("#issues-tab").click();
        $(withText("[BUG] Пользователь может добавить категорию трат без названия")).should(Condition.exist);
    }
}
