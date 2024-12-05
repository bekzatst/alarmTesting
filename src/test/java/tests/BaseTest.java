package tests;

import aquality.appium.mobile.application.AqualityServices;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static io.qameta.allure.Allure.step;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeTest
    public void setup() {
        step("Get driver instance");
        driver = (AndroidDriver) AqualityServices.getApplication().getDriver();
    }

    @AfterTest
    public void tearDown() {
        step("Closing the driver");
        if (driver != null) {
            driver.quit();
        }
    }
}
