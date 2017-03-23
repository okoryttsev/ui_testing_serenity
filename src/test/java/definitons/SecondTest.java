package definitons;

import net.serenitybdd.jbehave.SerenityStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * @author Sasha on 3/23/2017.
 */
public class SecondTest extends SerenityStory {
    @Given("opened specific browser")
    public void Open(){
        System.out.println("Step1");
    }

    @When("user filled some value")
    public void fillValue(){
        System.out.println("Fill value");
    }

    @Then("verify search results")
    public void results(){
        System.out.println("results");
    }
}
