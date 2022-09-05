package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class DarkskyHome extends Base {

    By timeList = By.xpath("//span[@class='hour']/span");
    By currentTempRaw = By.xpath("//span[@class='summary swap']");
    By timelineTempRaw = By.xpath("//span[@class='first']//span");

    By expectedLowTemp = By.xpath("//span[@class='low-temp-text']"); // 99˚
    By expectedHighTemp= By.xpath("//span[@class='high-temp-text']");


    By actualLowestTemp = By.xpath("//a[@data-day='0']//span[@class='minTemp']"); // 99˚
    By actualHighestTemp= By.xpath("//a[@data-day='0']//span[@class='maxTemp']");

    By lnkDarkskyAPI = By.xpath("//a[normalize-space()='Dark Sky API']");

    public void clickDarkSkyAPI()
    {
        clickOn(lnkDarkskyAPI);
    }

    public ArrayList<Integer> getActualTempList()
    {
        String lowTempStr = getTextFromElement(actualLowestTemp).split("˚")[0];
        String highTempStr = getTextFromElement(actualHighestTemp).split("˚")[0];

        ArrayList<Integer> tempList = new ArrayList()
        {{
            add(Integer.parseInt(lowTempStr));
            add(Integer.parseInt(highTempStr));
        }};

        return tempList;
    }



    public ArrayList<Integer> getExpectedTempList()
    {
        String lowTempStr = getTextFromElement(expectedLowTemp).split("˚")[0];
        String highTempStr = getTextFromElement(expectedHighTemp).split("˚")[0];

        ArrayList<Integer> tempList = new ArrayList()
        {{
            add(Integer.parseInt(lowTempStr));
            add(Integer.parseInt(highTempStr));
        }};

        return tempList;
    }


    public int getCurrentTemp()
    {
        String timeStr = getTextFromElement(currentTempRaw).split("˚")[0];
        // "89˚ Mostly Cloudy."
        // {"89"," Mostly Cloudy."}

        return  Integer.parseInt(timeStr);
    }

    public int getTimeLineTemp()
    {
        String timeStr = getTextFromElement(timelineTempRaw).split("°")[0];
        // "89°"
        // {"89"}

        return  Integer.parseInt(timeStr);
    }



    public ArrayList<Integer> getTimeList()
    {
            ArrayList<String> timeRaw = getElementTextList(timeList); // 11am , 1pm
             ArrayList<Integer> timeList = new ArrayList<>();
            for (int i=0;i<timeRaw.size();i++)
            {
                int l= timeRaw.get(i).length();
                String timeStr = timeRaw.get(i).substring(0,l-2); // 11 ,1
                int time = Integer.parseInt(timeStr);
                timeList.add(time);
            }

            return timeList;
    }
}
