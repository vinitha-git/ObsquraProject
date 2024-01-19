package org.qalegend.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.qalegend.automationcore.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.page.AddUsersPage;
import org.qalegend.page.HomePage;
import org.qalegend.page.LoginPage;
import org.qalegend.page.UserManagementPage;
import org.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.qalegend.utilities.ExcelUtility.readData;

public class AddUsersPageTest extends Base {
    @Test
    public void verifyAddUserPageTitle() {
        LoginPage login=new LoginPage(driver);
        ArrayList<String> data= ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH,Constants.LOGIN_PAGE);
        String username=data.get(1);
        login.enterUserName(username);
        String password=data.get(2);
        login.enterPassWord(password);
        HomePage home=login.clickOnLoginButtonElement();
        home.clickOnUserManagement();
        home.clickOnUsersOption();
        String actualUserPageTitle= home.getTitle();
        ArrayList<String> newData=ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH,Constants.ADD_USER_PAGE);
        String expectedUserPageTitle= newData.get(1);
        Assert.assertEquals(actualUserPageTitle,expectedUserPageTitle, Messages.TITLE_MISMATCH);


    }
    @Test
    public void verifyAddUser() {
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String username = data.get(1);
        login.enterUserName(username);
        String password = data.get(2);
        login.enterPassWord(password);
        HomePage home = login.clickOnLoginButtonElement();
        AddUsersPage users = new AddUsersPage(driver);
       users.clickOnUsersManagement();
    }
    @Test
    public void verifyUserLoginWithNewlyAddedUser() {

    }
}
