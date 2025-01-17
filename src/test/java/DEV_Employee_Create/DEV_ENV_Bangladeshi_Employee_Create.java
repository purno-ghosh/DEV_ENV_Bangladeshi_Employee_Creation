package DEV_Employee_Create;
import Setup_All.Setup;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DEV_ENV_Bangladeshi_Employee_Create {

    private WebDriver driver;
    private Setup setup;
    @FindBy(xpath = "//input[@name=\"email\"]")
    WebElement email_field;
    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement password_field;
    @FindBy(xpath = "//span[text()=\" Login \"]")
    WebElement login_click;
    @FindBy(xpath = "//span[span[text()='Add Employee']]")
    WebElement Add_Employee;

    @FindBy(xpath = "//h2/span[text()=\"Add Employee\"]")
    WebElement get_Add_Employee;

    @FindBy(xpath = "//mat-select")
    WebElement Salutation;

    @FindBy(xpath = "//mat-option[@value=\"MR\"]")
    WebElement Salutation_select;
    @FindBy(xpath = "//div/input[@name=\"FirstName\"]")
    WebElement userfirstName;

    @FindBy(xpath = "//div/input[@name=\"FirstName\"]")
    WebElement userlastName;

    public DEV_ENV_Bangladeshi_Employee_Create(WebDriver driver) {
        this.driver = driver;
        this.setup = new Setup();
        PageFactory.initElements(driver, this);
    }

public void create_employee() throws IOException {
    ZoneId bangladeshZone = ZoneId.of("Asia/Dhaka");
    ZonedDateTime bangladeshDateTime = ZonedDateTime.now(bangladeshZone);
    String testData = bangladeshDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yy-HH-mm"));
    System.out.println(testData);
    String lastName = testData;
    String employeeId = testData;
    String useremail = testData + "@yopmail.com";


    String email = Setup.getConfigData("userEmail");
    String password = Setup.getConfigData("password");
    
    email_field.sendKeys(email);
    password_field.sendKeys(password);
    login_click.click();
    Add_Employee.click();

    Salutation.click();
    Salutation_select.click();



    File file = new File("testData.txt");
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        writer.write("lastName=" + lastName + "\n");
        writer.write("employeeId=" + employeeId + "\n");
        writer.write("useremail=" + useremail + "\n");
    }

    System.out.println("Test data saved to file:");
    System.out.println("lastName=" + lastName);
    System.out.println("employeeId=" + employeeId);
    System.out.println("email=" + useremail);
}





}

