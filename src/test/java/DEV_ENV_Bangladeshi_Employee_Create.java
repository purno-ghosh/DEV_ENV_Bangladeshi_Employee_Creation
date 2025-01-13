import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DEV_ENV_Bangladeshi_Employee_Create {

    public WebDriver driver;


    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void aaa() {
        driver.get("https://selisehr.seliselocal.com/login");
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("shr@yopmail.com");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("123456789aA!");
        driver.findElement(By.xpath("//span[text()=\" Login \"]")).click();
        System.out.println("looks good");

        System.out.println("All Ok");
    }

}
