package utils;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Driver {
    public static RemoteWebDriver driver;
    public static WebDriverWait wait;
    private static final Properties properties = new Properties();

    public void initDriver() {
        try {
            properties.load(new FileReader("src/main/java/resources/test.properties"));
            driver = DriverFactory.driverInit(properties.getProperty("browser"));
            assert driver != null;
            wait = new WebDriverWait(driver,15);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void teardown(){
        driver.quit();
    }
}
