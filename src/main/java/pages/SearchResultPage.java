package pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * @author Sasha on 3/21/2017.
 */
public class SearchResultPage {

    private WebDriver driver;

    @FindBy(css = "div[class='rc']")
    private List<WebElement> results;

    @FindBy(css = "div[id='resultStats']")
    private WebElement resultStat;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getResults(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(resultStat));
        return results;
    }
}
