import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BasicTest;
import po.HomePage;
import util.Property;

public class LoginTest extends BasicTest {

    @FindBy(xpath = "//input[@name='email']")
    WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//div[contains(text(),'Login')]")
    WebElement loginButton;

    public LoginTest(){
        PageFactory.initElements(driver, this);
    }

    public HomePage login(){
        userName.sendKeys(Property.USERNAME);
        password.sendKeys(Property.PASSWORD);
        loginButton.click();
        return new HomePage();
    }
}
