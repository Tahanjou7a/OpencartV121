package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver) {super(driver);}

    @FindBy(xpath="//input[@id='input-email']")
    WebElement lnkEmail;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement lnkPassword;

    @FindBy(xpath="//input[@value='Login']")
    WebElement linkLogin;



    public void setEmail(String email)
    {
        lnkEmail.sendKeys(email);
    }

    public void setPassword(String pwd)
    {
        lnkPassword.sendKeys(pwd);
    }

    public void clickLogin() {linkLogin.click();}

}
