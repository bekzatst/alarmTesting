package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.IElementFactory;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class MainScreen extends Screen {
    IElementFactory elementFactory = AqualityServices.getElementFactory();

    private final By addAlarmBtnLoc = By.xpath("//android.widget.ImageButton[@resource-id='com.better.alarm:id/fab']");

    private IButton addAlarmBtn = elementFactory.getButton(addAlarmBtnLoc, "Add Alarm Button");

    private ITextBox clockTime = elementFactory.getTextBox(By.id("com.better.alarm:id/digital_clock_time"), "Time");
    private ITextBox amOrPm = elementFactory.getTextBox(By.id("com.better.alarm:id/digital_clock_am_pm"), "Am Or Pm");

    public MainScreen() {
        super(By.id("com.better.alarm:id/action_bar_container"), "Main Screen");
    }

    public void clickAddAlarmBtn(){
        addAlarmBtn.click();
    }

    public boolean isAlarmDisplayed() {
        return clockTime.state().waitForDisplayed();
    }

    public String getClockTime() {
        return clockTime.getText();
    }

    public String getAmOrPm() {
        return amOrPm.getText();
    }

}
