package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    public void setUp() {
        driver = DriverFactory.initDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
