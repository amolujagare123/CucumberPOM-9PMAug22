package pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static stepdefinition.SharedSD.getDriver;

public class HotelsSearchResult extends Base {


    public void clickStarRating(String starRating)
    {
        By rating = By.xpath("//div[@data-filters-group='class']//input[@value='class="+starRating+"']");
     //   clickOn(rating);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click()",webAction(rating));
    }


}
