package Setup_All;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class Setup {

    public static WebDriver driver;
    public static Properties configProperties;

    @BeforeClass
    public void setup() throws IOException {
        // Remove static declaration of driver
        configProperties = new Properties();
        InputStream fileInput = getClass().getClassLoader().getResourceAsStream("config.properties");

        if (fileInput == null) {
            throw new IOException("config.properties file not found in src/test/resources!");
        }

        configProperties.load(fileInput);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String baseUrl = configProperties.getProperty("url");
        driver.get(baseUrl);
    }


    @AfterMethod
    public void takeScreenshot(ITestResult result) throws IOException {
        Utils utils = new Utils(driver);  // Initialize your custom Utils class for taking screenshots
        if (ITestResult.FAILURE == result.getStatus()) {
            // Take screenshot if the test fails
            utils.takeScreenShot("failure");
        } else if (ITestResult.SUCCESS == result.getStatus()) {
            // Take screenshot if the test passes
            utils.takeScreenShot("success");
        }
    }


//    @AfterClass
//    public void close() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    public static String getConfigData(String propertyName) {
        return configProperties.getProperty(propertyName);
    }
}
