package pages;

import org.openqa.selenium.By;

public class DarkSkyLogin extends DarkSkyAPI {

    By btnLogin = By.xpath("//button[normalize-space()='Log in']");

    public void clickBtnLogin()
    {
        clickOn(btnLogin);
    }


}
