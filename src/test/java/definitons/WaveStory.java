package definitons;

import net.serenitybdd.jbehave.SerenityStory;
import org.apache.commons.lang3.StringUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.ConstantsWave;
import pages.FirstPage;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author Sasha on 3/23/2017.
 */
public class WaveStory extends SerenityStory{
    private static final Logger LOGGER = Logger.getLogger(FirstTest.class.getName());

    private static WebDriver driver;
    private FirstPage firstPage;

    @Given("opened browser on $path")
    public void openBrowserOn(String path){
        String value2fill= StringUtils.isEmpty(path)?"https://www.google.com/":path;

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();

        options.addExtensions(new File("extension/extension_1_0_5.crx"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        LOGGER.info("open chrome driver on "+value2fill);
        firstPage = new FirstPage(driver);
        firstPage.getDriver().get(value2fill);
    }

    @When("verify redirect is correct")
    public void redirectIsCorrect(){
        Assert.assertTrue("Title should be present",StringUtils.isEmpty(firstPage.getDriver().getTitle()));
    }

    @Then("verify wave errors")
    public void verifyWaveErrors(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(ConstantsWave.WAVE_RUN);
        List<WebElement> errors = driver.findElements(By.cssSelector("img[alt*='ERRORS']"));
        Assert.assertEquals(0,errors.size());
    }
}
