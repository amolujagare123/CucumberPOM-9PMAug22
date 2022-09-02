package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DarkskyHome;

import java.util.ArrayList;
import java.util.Collections;

import static stepdefinition.SharedSD.getDriver;

public class Darksky {

   DarkskyHome darkskyHome = new DarkskyHome();

    @Given("I am on Darksky Home Page")
    public void i_am_on_darksky_home_page() {

        Assert.assertEquals("This is not darksky home page",
                "Dark Sky - Sansad Marg, New Delhi, Delhi"
                ,getDriver().getTitle());

    }
    @Then("I verify current temp is equal to Temperature from Daily Timeline")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline() {

        int expected = darkskyHome.getCurrentTemp();
        int actual = darkskyHome.getTimeLineTemp();
        System.out.println("expected="+expected);
        System.out.println("Actual="+actual);

        Assert.assertEquals("temetarures are differnt",expected,actual);

    }

    @Then("I verify timeline is displayed with two hours incremented")
    public void iVerifyTimelineIsDisplayedWithTwoHoursIncremented() {

        ArrayList<Integer> timeList = darkskyHome.getTimeList();
        System.out.println(timeList);
      // [11, 1, 3, 5, 7, 9, 11, 1, 3, 5, 7]
        ArrayList<Integer> timeDiffList = new ArrayList<>();
        for (int i=0;i<timeList.size()-1;i++)
        {
            int time1 = timeList.get(i);
            int time2 = timeList.get(i+1);
            int timeDiff = 0;

            if(time2>time1)
                timeDiff = time2-time1;
            if(time1>time2)
           // else
                timeDiff = (time2+12)-time1;

            timeDiffList.add(timeDiff);
        }
        System.out.println(timeDiffList);

       /* boolean flag = true;
        for(int i=0;i<timeDiffList.size();i++)
        {
            if(timeDiffList.get(i)!=2)
                flag =false;
        }

        Assert.assertTrue("all the differences are not 2"
                ,flag);*/

     /*  ArrayList<Integer> expected = new ArrayList<Integer>()
        {{
            for(int i=0;i<10;i++)
                 add(2);
        }};

        System.out.println("expected="+expected);
        System.out.println("Actual="+timeDiffList);

      boolean result =  expected.equals(timeDiffList);

        Assert.assertEquals("",expected,timeDiffList);*/

        int occurrence  = Collections.frequency(timeDiffList,2);
        int size = timeDiffList.size();

        System.out.println("expected="+occurrence);
        System.out.println("Actual="+size);

        boolean result = (occurrence==size);
        Assert.assertTrue("all the differences are not 2",result);


    }




}
