package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AlarmScreen;
import screens.MainScreen;

import static io.qameta.allure.Allure.step;

public class AppiumTest extends BaseTest {

    protected MainScreen mainScreen = new MainScreen();
    protected AlarmScreen alarmScreen = new AlarmScreen();

    @Test
    public void appiumTest() {
        // Your test steps go here
        step("Clicking add alarm button");
        mainScreen.clickAddAlarmBtn();
        alarmScreen.state().waitForDisplayed();
        step("Click 1");
        alarmScreen.clickOneBtn();
        step("Click 5");
        alarmScreen.clickFiveBtn();
        step("Click 0");
        alarmScreen.clickZeroBtn();
        step("Click PM");
        alarmScreen.clickPmBtn();
        step("Set alarm");
        alarmScreen.clickSetBtn();
        step("Save alarm");
        alarmScreen.clickSaveBtn();
        Assert.assertTrue(mainScreen.isAlarmDisplayed(), "Alarm is not displayed");
        Assert.assertEquals(mainScreen.getClockTime(), "1:50");
        Assert.assertEquals(mainScreen.getAmOrPm(), "PM");
    }

}
