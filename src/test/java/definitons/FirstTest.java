package definitons;

import net.serenitybdd.jbehave.SerenityStory;
import org.apache.commons.lang3.StringUtils;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.FirstPage;
import pages.SearchResultPage;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author Sasha on 3/22/2017.
 */
public class FirstTest extends SerenityStory {
    private static final Logger LOGGER = Logger.getLogger(FirstTest.class.getName());

    private WebDriver driver;


    @Given("opened google page")
    public void openedGooglePage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();

        options.addExtensions(new File("extension/extension_1_0_5.crx"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        LOGGER.info("open chrome driver on https://www.google.com");
    }

    @When("user fill search field with $value")
    public void usserFillSearchField(String value) {
        String value2fill = StringUtils.isEmpty(value) ? "MNTU" : value;
        LOGGER.info("value to fill search field is " + value2fill);
        FirstPage firstPage = new FirstPage(driver);
        firstPage.getDriver().get("https://www.google.com/");
        firstPage.inputValue(value2fill);
    }

    @Then("verify search result is present")
    public void verifyResult() throws InterruptedException {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assert.assertTrue("Results are empty", searchResultPage.getResults().size() > 0);
    }

    @AfterStory
    public void end() {
        driver.quit();
    }

}
