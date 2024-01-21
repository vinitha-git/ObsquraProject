package org.qalegend.test;

import org.qalegend.automationcore.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.page.LoginPage;
import org.qalegend.page.ResetPage;
import org.qalegend.retryanalyzer.RetryAnalyzer;
import org.qalegend.utilities.ExcelUtility;
import org.qalegend.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class ResetPageTest extends Base {
    @Test(groups ="Sanity")
    public void verifyResetPageTitle() {
        LoginPage login=new LoginPage(driver);
        ResetPage reset=login.clickOnforgotPassWordMenu();
        String actualPageTitle=reset.getPageTitle();
        ArrayList<String> data= ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH,Constants.RESET_PAGE);
        String expectedPageTitle=data.get(1);
        Assert.assertEquals(actualPageTitle,expectedPageTitle, Messages.TITLE_MISMATCH);
    }
    @Test(groups = "Regression")
    public void verifyErrorMessageWithInvalidEmailID() {
        String firstName = RandomDataUtility.getFirstName();
        String lastName = RandomDataUtility.getLastName();
        String emailID = firstName + "." + lastName + "123@yahoo.com";
        LoginPage login=new LoginPage(driver);
        ResetPage reset=login.clickOnforgotPassWordMenu();
        reset.enterEmailAdress(emailID);
        reset.clickOnSendPassWordRestLink();
        String actualErrorMessage= reset.getText();
        ArrayList<String> data=ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH,Constants.RESET_PAGE);
        String expectedErrorMessage= data.get(3);
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,Messages.WRONG_USER_EMAIL);
    }
}