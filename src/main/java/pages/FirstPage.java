package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sasha on 3/21/2017.
 */
public class FirstPage{
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public FirstPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "q")
    private WebElement searchField;

    public void inputValue(final String value){
        searchField.clear();
        searchField.sendKeys(value);
        searchField.sendKeys(Keys.ENTER);
    }
}
