package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * @author Sasha on 3/21/2017.
 */
public class FirstPage {

    @FindBy(name = "q")
    private WebElement searchField;

    public void inputValue(final String value){
        searchField.clear();
        searchField.sendKeys(value);
        searchField.sendKeys(Keys.ENTER);
    }
}
