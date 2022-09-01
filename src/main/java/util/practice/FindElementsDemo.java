package util.practice;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static util.ConfigReader.getUrl;

public class FindElementsDemo {

    @Test
    public void mytest1()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.amolujagare.com/");

        List<WebElement> elementList = driver.findElements(By.tagName("input"));

        System.out.println("size="+elementList.size());

        elementList.get(0).sendKeys("admin"); // username
        elementList.get(1).sendKeys("admin"); // password
        elementList.get(2).click(); // button login



    }
}
