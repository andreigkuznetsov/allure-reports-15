import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    @Test
    public void annotatedStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(TestData.REPOSITORY);
        steps.clickOnRepositoryLink(TestData.REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(TestData.ISSUE);
        steps.takeScreenshot();
    }

}
