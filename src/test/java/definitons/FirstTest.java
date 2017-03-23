package definitons;

import net.serenitybdd.jbehave.SerenityStory;
import org.apache.commons.lang3.StringUtils;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import pages.FirstPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author Sasha on 3/22/2017.
 */
public class FirstTest extends SerenityStory {

    private FirstPage firstPage;
    private WebDriver driver;

    
    @Given("opened google page")
    public void openedGooglePage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();

        options.addExtensions(new File("extension/extension_1_0_5.crx"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        firstPage = PageFactory.initElements(driver,FirstPage.class);
    }

    @When("user fill search field with $value")
    public void usserFillSearchField(String value) {
        String value2fill = StringUtils.isEmpty(value) ? "MNTU" : value;
        firstPage = PageFactory.initElements(driver,FirstPage.class);
        firstPage.inputValue(value2fill);
    }

    @Then("verify search result is present")
    public void verifyResult() throws InterruptedException {

    }

    @AfterStory
    public void end(){
        driver.close();
        driver.quit();
    }

}
