package DEV_Employee_Create;
import Setup_All.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DEV_ENV_Bangladeshi_Employee_Create {

    private WebDriver driver;
    private Setup setup;
    @FindBy(xpath = "//input[@name=\"email\"]")
    WebElement email_field;
    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement password_field;
    @FindBy(xpath = "//span[text()=\" Login \"]")
    WebElement login_click;

    public DEV_ENV_Bangladeshi_Employee_Create(WebDriver driver) {
        this.driver = driver;
        this.setup = new Setup();
        PageFactory.initElements(driver, this);
    }

public void create_employee(){

    String email = Setup.getConfigData("userEmail");
    String password = Setup.getConfigData("password");
    
    email_field.sendKeys(email);
    password_field.sendKeys(password);
    login_click.click();

}
}
