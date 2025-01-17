package Setup_All;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.reporters.XMLReporter;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Utils {

    private WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void takeScreenShot(String status) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Format the timestamp for uniqueness
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());

        // Save screenshot in src/test/resources/screenshot folder
        String fileWithPath = "src/test/resources/screenshots/" + status + "-" + time + ".png";

        File destFile = new File(fileWithPath);
        FileUtils.copyFile(screenshotFile, destFile);
    }
}
