package org.qalegend.test;

import org.qalegend.automationcore.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.dataprovider.DataProviders;
import org.qalegend.page.HomePage;
import org.qalegend.page.LoginPage;
import org.qalegend.retryanalyzer.RetryAnalyzer;
import org.qalegend.utilities.ExcelUtility;
import org.qalegend.utilities.WebElementUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.qalegend.utilities.ExcelUtility.readData;

public class LoginPageTest extends Base {
    @Test(groups = "Sanity")
    public void verifyLoginPageTitle() {
        LoginPage login=new LoginPage(driver);
        String actualPageTitle = login.getPageTitle();
        ArrayList <String> data= readData(Constants.TEST_DATA_EXCEL_PATH,Constants.LOGIN_PAGE);
        String expectedPageTitle= data.get(0);
        Assert.assertEquals(actualPageTitle,expectedPageTitle, Messages.TITLE_MISMATCH);
    }
    @Test(groups ="Smoke")
    public void verifyUserLoginWithValidCredentials() {
        LoginPage login=new LoginPage(driver);
        ArrayList<String> data=readData(Constants.TEST_DATA_EXCEL_PATH,Constants.LOGIN_PAGE);
        String username=data.get(1);
        login.enterUserName(username);
        String password=data.get(2);
        login.enterPassWord(password);
        HomePage home=login.clickOnLoginButtonElement();
        login.clickOnEndTourButton();
        String actualLoggedAccount=home.getUserLoggedAccount();
        String expectedLoggedAccount= data.get(6);
        Assert.assertEquals(actualLoggedAccount,expectedLoggedAccount,Messages.LOGIN_FAILED);
    }
    @Test(groups="Smoke")
    public void verifyErrorMessageWhileLoginWithInvalidCredentials(String userName,String passWord) {
        LoginPage login=new LoginPage(driver);
        login.enterUserName(userName);
        login.enterPassWord(passWord);
        login.clickOnLoginButtonElement();
        String actualErrorMessage=login.getText();
        ArrayList<String> data=ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH,Constants.LOGIN_PAGE);
        String expectedErrorMessage= data.get(5);
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,Messages.LOGIN_FAILED);
    }
}