package util.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LoginDemo {

    @Test
    public void mytest1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.amolujagare.com/");

      //  Thread.sleep(10000);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("submit"))));


        List<WebElement> elementList = driver.findElements(By.tagName("input"));

        System.out.println("size="+elementList.size());

        elementList.get(0).sendKeys("admin"); // username
        elementList.get(1).sendKeys("admin"); // password
        elementList.get(2).click(); // button login



    }
}
