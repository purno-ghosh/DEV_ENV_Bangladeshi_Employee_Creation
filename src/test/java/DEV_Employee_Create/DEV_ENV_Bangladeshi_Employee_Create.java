package DEV_Employee_Create;
import Setup_All.Setup;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
import java.time.YearMonth;
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

    @FindBy(xpath = "//mat-select")
    WebElement Salutation;

    @FindBy(xpath = "//mat-option[@value=\"MR\"]")
    WebElement Salutation_select;
    @FindBy(xpath = "//div/input[@name=\"FirstName\"]")
    WebElement userfirstName;

    @FindBy(xpath = "//div/input[@name=\"LastName\"]")
    WebElement userlastName;

    @FindBy(xpath = "//button[@aria-label='Open calendar']")
    WebElement joiningDate;

    @FindBy(xpath = "//mat-select[@aria-label='Employment Location']")
    WebElement Employment_Location;

    @FindBy(xpath = "//span[normalize-space()='Bangladesh']")
    WebElement Select_Employment_Location;


    @FindBy(xpath = "//mat-select[@aria-label=\"Unit\"]")
    WebElement clickUnit;

    @FindBy(xpath = "//input[@formcontrolname=\"Designation\"]")
    WebElement Designation;


    @FindBy(xpath = "//mat-select[@formcontrolname=\"Sex\"]")
    WebElement gender;

    @FindBy(xpath = "//span[normalize-space()='Male']")
    WebElement selectgender;


    @FindBy(xpath = "//input[@formcontrolname=\"EmployeeID\"]")
    WebElement EmployeeID;



    @FindBy(xpath = "//mat-select[@formcontrolname=\"LanguagePreference\"]")
    WebElement LanguagePreference;

    @FindBy(xpath = "//span[normalize-space(text())='English']")
    WebElement selectLanguagePreference;

    @FindBy(xpath = "//button[span[text()=' Next ']]")
    WebElement Next;


    @FindBy(xpath = "(//input[@formcontrolname='Email'])[1]")
    WebElement enteruseremail;

    @FindBy(xpath = "//mat-select[@formcontrolname='Country']")
    WebElement countryField;
    @FindBy(xpath = "//mat-option/span[normalize-space()='Bangladesh']")
    WebElement countryselect;



    @FindBy(xpath = "//mat-select[@formcontrolname='Canton']")
    WebElement cantonField;

    @FindBy(xpath = "(//mat-option)[1]")
    WebElement selectCanton;
    @FindBy(xpath = "//input[@name=\"City\"]")
    WebElement cityfield;

    @FindBy(xpath = "//input[@name=\"ZipCode\"]")
    WebElement zipfield;

    @FindBy(xpath = "//input[@name=\"EmergencyContactName\"]")
    WebElement EmergencyContactNamefield;
    @FindBy(xpath = "//input[@placeholder=\"Telephone Number *\"]")
    WebElement Telephone_Number;
    @FindBy(xpath = "//input[@name=\"EmergencyContactRelationship\"]")
    WebElement EmergencyContactRelations;

    @FindBy (xpath = "(//mat-datepicker-toggle/button[@type=\"button\"])[3]")
    WebElement Hr_Start_button;
    @FindBy (xpath = "//button/div[normalize-space(text())=\"1\"]")
    WebElement Click_Hr_Start_Date;

    @FindBy (xpath = "(//mat-datepicker-toggle/button[@type=\"button\"])[4]")
    WebElement Hr_End_button;

    @FindBy (xpath = "//button[@aria-label=\"Next month\"]")
    WebElement nextMonthbutton;

    @FindBy (xpath = "//mat-select[@formcontrolname=\"EmploymentType\"]")
    WebElement Employment_dropdown;


    @FindBy (xpath = "//mat-option[contains(@class, 'mat-option')]//span[normalize-space()='Full Time']")
    WebElement Select_Employment_Type;

    @FindBy(xpath = "//button[span[normalize-space(text())='Monday']]")
    WebElement Monday_Button;

    @FindBy(xpath = "//button[span[normalize-space(text())='Tuesday']]")
    WebElement Tuesday_Button;

    @FindBy(xpath = "//button[span[normalize-space(text())='Wednesday']]")
    WebElement Wednesday_Button;

    @FindBy(xpath = "//button[span[normalize-space(text())='Thursday']]")
    WebElement Thursday_Button;

    @FindBy(xpath = "//button[span[normalize-space(text())='Sunday']]")
    WebElement Sunday_Button;

    @FindBy(xpath = "//span[@class='mat-checkbox-label'][contains(text(), 'Annual Leave')]")
    WebElement Annual_Leave;

    @FindBy(xpath = "//span[@class='mat-checkbox-label'][contains(text(), 'Paternity Leave')]")
    WebElement Paternity_Leave;

    @FindBy(xpath = "//span[@class='mat-checkbox-label'][contains(text(), 'Sick Leave')]")
    WebElement Sick_Leave;

    @FindBy(xpath = "//h3[normalize-space(text())='Leave Carry Forward *']")
    WebElement Leave_Carry_Forward;


    public DEV_ENV_Bangladeshi_Employee_Create(WebDriver driver) {
        this.driver = driver;
        this.setup = new Setup();
        PageFactory.initElements(driver, this);
    }

public void create_employee() throws IOException, InterruptedException {
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

    userfirstName.sendKeys("AutoTest");
    userlastName.sendKeys(testData);

    WebElement element = driver.findElement(By.xpath("//mat-select[@formcontrolname='LanguagePreference']"));
    Actions actions = new Actions(driver);
    actions.moveToElement(element).perform();

    Thread.sleep(2000);

    joiningDate.click();
    int dateonly = Integer.parseInt(testData.split("-")[0]);
    System.out.println(dateonly);
    driver.findElement(By.xpath("//div[normalize-space()='" + dateonly + "']")).click();
    Employment_Location.click();

    Select_Employment_Location.click();

    clickUnit.click();

    WebElement retailOption = driver.findElement(By.xpath("//span[normalize-space()='Retail']"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", retailOption);
    Thread.sleep(2000);
    retailOption.click();
    Thread.sleep(2000);
    Designation.sendKeys(testData);

    gender.click();
    selectgender.click();
    EmployeeID.sendKeys(testData);
    LanguagePreference.click();
    selectLanguagePreference.click();
    Thread.sleep(2000);
    WebElement dateOfBirthInput = driver.findElement(By.xpath("//input[@formcontrolname='DateOfBirth']"));
    Actions actions2 = new Actions(driver);
    actions2.moveToElement(dateOfBirthInput).perform();
    Next.click();
    enteruseremail.sendKeys(useremail);
    countryField.click();
    Thread.sleep(2000);
    countryselect.click();
    Thread.sleep(2000);
    cantonField.click();
    selectCanton.click();
    cityfield.sendKeys(testData);
    zipfield.sendKeys(testData);

    WebElement element3 = driver.findElement(By.xpath("//span[text()=\"Email (Business)\"]"));
    Actions actions3 = new Actions(driver);
    actions3.moveToElement(element3).perform();

    EmergencyContactNamefield.sendKeys("Father");
    EmergencyContactRelations.sendKeys("Father");
    Thread.sleep(2000);
    Telephone_Number.sendKeys("+880 1629889679");
    Thread.sleep(2000);
    Next.click();
    YearMonth currentMonth = YearMonth.now().plusMonths(1);
    int lastDate = currentMonth.lengthOfMonth();
    System.out.println(lastDate);

    WebElement hrTermElement = driver.findElement(By.xpath("//div[@class='term-name' and text()='HR Term 1']"));

    // Scroll to the element using JavaScript
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hrTermElement);
    Thread.sleep(2000);
    Hr_Start_button.click();
    Click_Hr_Start_Date.click();
    Hr_End_button.click();
    nextMonthbutton.click();
    driver.findElement(By.xpath("//button/div[normalize-space(text())='" + lastDate + "']")).click();
    Employment_dropdown.click();
    Select_Employment_Type.click();
    Next.click();
    Thread.sleep(2000);
    Monday_Button.click();
    Tuesday_Button.click();
    Wednesday_Button.click();
    Thursday_Button.click();

    Sunday_Button.click();
    Annual_Leave.click();
    git sThread.sleep(1000);
    Paternity_Leave.click();
    Sick_Leave.click();
    Next.click();

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

