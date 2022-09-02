package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class DarkskyHome extends Base {

    By timeList = By.xpath("//span[@class='hour']/span");
    By currentTempRaw = By.xpath("//span[@class='summary swap']");
    By timelineTempRaw = By.xpath("//span[@class='first']//span");


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
