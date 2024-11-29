package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AlarmScreen;
import screens.MainScreen;

public class AppiumTest extends BaseTest {

    protected MainScreen mainScreen = new MainScreen();
    protected AlarmScreen alarmScreen = new AlarmScreen();

    @Test
    public void appiumTest() {
        // Your test steps go here
        mainScreen.clickAddAlarmBtn();
        alarmScreen.state().waitForDisplayed();
        alarmScreen.clickOneBtn();
        alarmScreen.clickFiveBtn();
        alarmScreen.clickZeroBtn();
        alarmScreen.clickPmBtn();
        alarmScreen.clickSetBtn();
        alarmScreen.clickSaveBtn();
        Assert.assertTrue(mainScreen.isAlarmDisplayed(), "Alarm is not displayed");
        Assert.assertEquals(mainScreen.getClockTime(), "1:50");
        Assert.assertEquals(mainScreen.getAmOrPm(), "PM");
    }

}
