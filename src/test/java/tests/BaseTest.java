package tests;

import aquality.appium.mobile.application.AqualityServices;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeTest
    public void setup() {
        driver = (AndroidDriver) AqualityServices.getApplication().getDriver();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
