package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass{
    @Test(groups = {"Sanity","Master"})
    public void verifyLogin() {
        logger.info("*****Starting TC002_LoginTest*****");
    try {
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.setEmail(p.getProperty("email"));
        lp.setPassword(p.getProperty("pwd"));
        lp.clickLogin();

        MyAccountPage macc = new MyAccountPage(driver);
        boolean targetPage = macc.isMyAccountPageExists();

        //Assert.assertEquals(targetPage,true,"Login failed");
        Assert.assertTrue(targetPage);
    }
    catch (Exception e)
    {
        logger.error(e.getMessage());
        Assert.fail();
    }
        logger.info("*****Finished TC002_LoginTest*****");
    }


}