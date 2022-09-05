package pages;

import org.openqa.selenium.By;

public class DarkSkyAPI extends DarkskyHome{

    By lnkLogin = By.xpath("//a[normalize-space()='Log In']");

    public void clickLnkLogin()
    {
        clickOn(lnkLogin);
    }

}
