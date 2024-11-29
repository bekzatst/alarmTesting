package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.IElementFactory;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class AlarmScreen extends Screen {

    IElementFactory elementFactory = AqualityServices.getElementFactory();

    private static final By ONE = By.xpath("//android.widget.Button[@resource-id='com.better.alarm:id/key_left' and @text='1']");
    private static final By FIVE = By.xpath("//android.widget.Button[@resource-id='com.better.alarm:id/key_middle' and @text='5']"); //android.widget.Button[@resource-id="com.better.alarm:id/key_middle" and @text="5"]
    private static final By ZERO = By.xpath("    //android.widget.Button[@resource-id='com.better.alarm:id/key_middle' and @text='0']");
    private static final By PM = By.xpath("    //android.widget.Button[@resource-id='com.better.alarm:id/key_right' and @text='PM']");

    private IButton oneBtn = elementFactory.getButton(ONE, "Button One");
    private IButton fiveBtn = elementFactory.getButton(FIVE, "Button Five");
    private IButton zeroBtn = elementFactory.getButton(ZERO, "Button Zero");
    private IButton pmButton = elementFactory.getButton(PM, "PM Button");
    private IButton setBtn = elementFactory.getButton(By.xpath("    //android.widget.Button[@resource-id='com.better.alarm:id/set_button']"), "Set Button");
    private IButton saveBtn = elementFactory.getButton(By.id("com.better.alarm:id/details_activity_button_save"), "Details save button");

    public AlarmScreen() {
        super(By.xpath("//android.widget.Button[@resource-id='com.better.alarm:id/key_left' and @text='1']"), "Alarm Screen");
    }

    public void clickOneBtn() {
        oneBtn.click();
    }

    public void clickFiveBtn() {
        fiveBtn.click();
    }

    public void clickZeroBtn() {
        zeroBtn.click();
    }

    public void clickPmBtn() {
        pmButton.click();
    }

    public void clickSetBtn() {
        setBtn.click();
    }

    public void clickSaveBtn() {
        saveBtn.click();
    }
}
