package Setup_All;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    private WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void takeScreenShot(String status) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-aa").format(new Date());
        String fileWithPath = "src/test/resources/screenshots/" + status + "-" + time + ".png";
        File destFile = new File(fileWithPath);
        if (destFile.exists()) {
            destFile.delete();
        }
        FileUtils.copyFile(screenshotFile, destFile);
    }
}
