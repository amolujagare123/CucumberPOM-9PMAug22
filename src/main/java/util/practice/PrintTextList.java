package util.practice;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PrintTextList {

    @Test
    public void printText()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://darksky.net/forecast/28.627,77.2154/us12/en");

        List<WebElement> timelist = driver.findElements(By.xpath("//span[@class='hour']/span"));

        System.out.println("size="+timelist.size());

        ArrayList<Integer> timeListInt = new ArrayList<>();

        for (int i=0;i<timelist.size();i++)
        {
            System.out.println( timelist.get(i).getText() );

            String timeRawStr = timelist.get(i).getText(); // 11pm , 1am
            int l = timeRawStr.length();

            String timeStr = timeRawStr.substring(0, l - 2); // 11 , 1
            int time = Integer.parseInt(timeStr);

            timeListInt.add(time);

        }

        System.out.println(timeListInt);


    }
}
