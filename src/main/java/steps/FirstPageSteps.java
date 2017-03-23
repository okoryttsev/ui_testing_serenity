package steps;


import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import pages.FirstPage;

import java.util.logging.Logger;

/**
 * @author Sasha on 3/21/2017.
 */
public class FirstPageSteps {
    private static final Logger LOGGER = Logger.getLogger(FirstPageSteps.class.getName());

    private WebDriver driver;

    private FirstPage firstPage;

    public FirstPageSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void initDriver() {
        firstPage = new FirstPage(driver);
    }

    @Step
    public void firstMove(final String path) {
        LOGGER.info("Open page " + path);
        firstPage.getDriver().get(path);
    }

    @Step
    public void inputValue(final String value) {
        LOGGER.info("value to fill is " + value);
        firstPage.inputValue(value);
    }


}
