package steps;

import jxl.common.Assert;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import pages.SearchResultPage;

import java.util.logging.Logger;

/**
 * @author Sasha on 3/21/2017.
 */
public class SearchResultSteps {
    private static final Logger LOGGER = Logger.getLogger(SearchResultSteps.class.getName());

    public SearchResultSteps(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    private SearchResultPage searchResultPage;

    @Step
    public void verifyResults() {
        searchResultPage = new SearchResultPage(driver);
        LOGGER.info("Perform verify for results");
        Assert.verify(searchResultPage.getResults().isEmpty(), "Results should be present");
    }
}
