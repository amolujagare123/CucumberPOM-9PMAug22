package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HotelsSearchResult;

import static stepdefinition.SharedSD.getDriver;

public class HotelsSD {

    HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen() throws Throwable {
        Assert.assertTrue("This is not bookings home page"
                ,getDriver().getTitle().contains("Hotels"));
    }

    @When("^I select option for stars as (.+)$")
    public void i_select_option_for_stars_as(String stars) throws Throwable {

        // String stars --> '5 Stars' --> stars.charAt(0)

        hotelsSearchResult.clickStarRating(stars.split(" ")[0]);
       // hotelsSearchResult.clickStarRating(""+stars.charAt(0));
    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) throws Throwable {

    }
}
