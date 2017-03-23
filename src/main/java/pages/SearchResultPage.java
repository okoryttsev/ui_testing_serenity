package pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * @author Sasha on 3/21/2017.
 */
public class SearchResultPage{
    private WebDriver driver;

    public SearchResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "div[class='rc']")
    private List<WebElement> results;

    @FindBy(css = "div[id='resultStats']")
    private WebElement resultStat;

    public List<WebElement> getResults(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(resultStat));
        return results;
    }
}
