package Setup_All;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Setup {

    public static WebDriver driver;
    public static Properties configProperties;

    @BeforeClass
    public void setup() throws IOException{
        configProperties = new Properties();
        File file = new File("config.properties");
        FileInputStream fileInp = new FileInputStream(file);
        configProperties.load(fileInp);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver=new ChromeDriver();
        String baseUrl=configProperties.getProperty("url");
        driver.get(baseUrl);
    }

    @AfterClass
    public  void close(){
        driver.quit();

    }


    public static String getConfigData(String propertyName) {
        return configProperties.getProperty(propertyName);
    }

}
