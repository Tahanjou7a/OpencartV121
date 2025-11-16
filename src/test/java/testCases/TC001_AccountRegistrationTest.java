package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

import java.lang.reflect.Executable;
import java.time.Duration;

public class TC001_AccountRegistrationTest extends BaseClass{


@Test(groups = {"Regression","Master"})
public void verify_account_registration() {
    logger.info("*****StartingT001_AccountRegistrationTest*****");

    try {
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickRegister();

        AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

        regpage.setFirstName("Jhon");                 //(randomeString().toUpperCase());
        regpage.setLastName("David");                 //(randomString().toUppoerCase());
        regpage.setEmail(randomeString() + "@gmail.com");// randomly generated the mail    ("abcjhondav1if@gmail.com");
        regpage.setTelephone(randomeNumber());                        //("23123123");

        String password = randomeAlphaNumberic();

        regpage.setPassword(password);                                 //(randomeAlphaNumberic());           // ("xyz13256");
        regpage.setConfirmPassword(password);                          //(randomeAlphaNumberic());    //      ("xyz13256");

        regpage.setPrivacyPolicy();
        regpage.clickContinue();

        logger.info("*****Validating expected message*****");

        String confmsg = regpage.getConfirmationMsg();

        Assert.assertEquals(confmsg, "Your Account Has Been Created!");
         }
        catch (Exception e)
        {
        logger.error("Test failed..");
        logger.debug("Debug logs..");
        Assert.fail();

        }
    logger.info("*****Finished TC001_AccountRegistrationTest*****");
}
}

