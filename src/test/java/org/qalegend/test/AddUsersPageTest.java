package org.qalegend.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.qalegend.automationcore.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.page.*;
import org.qalegend.utilities.ExcelUtility;
import org.qalegend.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;


    public class AddUsersPageTest extends Base {
        @Test(groups="Sanity")
        public void verifyAddUserPageTitle() {
            LoginPage login = new LoginPage(driver);
            ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
            String username = data.get(1);
            login.enterUserName(username);
            String password = data.get(2);
            login.enterPassWord(password);
            login.clickOnLoginButtonElement();
            HomePage home = login.clickOnEndTourButton();
            UserManagementPage usermanagement=home.clickOnUserManagement();
            UsersPage userPage =usermanagement.clickOnUsersOption();
            AddUsersPage addPage = userPage.clickOnAddButton();
            String actualUserPageTitle = addPage.getTitle();
            ArrayList<String> userPageData = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.ADD_USER_PAGE);
            String expectedUserPageTitle = userPageData.get(1);
            Assert.assertEquals(actualUserPageTitle, expectedUserPageTitle, Messages.TITLE_MISMATCH);
        }

        @Test(groups = "Smoke")
        public void verifyAddUser() {
            String firstName = RandomDataUtility.getFirstName();
            String lastName = RandomDataUtility.getLastName();
            String emailID = firstName + "." + lastName + "123@yahoo.com";
            String password = firstName + "." + lastName;
            LoginPage login = new LoginPage(driver);
            ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
            String loginUsername = data.get(1);
            login.enterUserName(loginUsername);
            String loginPassword = data.get(2);
            login.enterPassWord(loginPassword);
            login.clickOnLoginButtonElement();
            HomePage home = login.clickOnEndTourButton();
            home.clickOnUserManagement();
            UsersPage userPage = home.clickOnUsersOption();
            AddUsersPage adduser = userPage.clickOnAddButton();
            adduser.enterFirstName(firstName);
            adduser.enterLastName(lastName);
            adduser.enterEmailId(emailID);
            adduser.enterUserName(firstName);
            adduser.enterPassWord(password);
            adduser.enterconfirmPassWord(password);
            adduser.clickOnSaveButton();
        }

        @Test(groups = "Smoke")
        public void verifyUserLoginWithNewlyAddedUser() {
            LoginPage login = new LoginPage(driver);
            ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
            String loginUsername = data.get(1);
            login.enterUserName(loginUsername);
            String loginPassword = data.get(2);
            login.enterPassWord(loginPassword);
            login.clickOnLoginButtonElement();
            HomePage home=login.clickOnEndTourButton();
            UserManagementPage userManagement=home.clickOnUserManagement();
            UsersPage userPage = userManagement.clickOnUsersOption();
            AddUsersPage adduser = userPage.clickOnAddButton();
            ArrayList<String> userDatas=ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH,Constants.ADD_USER_PAGE);
            String firstName=userDatas.get(2);
            adduser.enterFirstName(firstName);
            String lastName=userDatas.get(3);
            adduser.enterLastName(lastName);
            String emailID=userDatas.get(4);
            adduser.enterEmailId(emailID);
            String userName=userDatas.get(2);
            adduser.enterUserName(userName);
            String passWord=userDatas.get(5);
            adduser.enterPassWord(passWord);
            String confirmPassWord=userDatas.get(5);
            adduser.enterconfirmPassWord(confirmPassWord);
            UsersPage usersPage=adduser.clickOnSaveButton();
            usersPage.clickOnUsersLoggedUserName();
            LoginPage page=usersPage.clickOnSignOutButton();
            String newUserNameToLogin=userDatas.get(2);
            login.enterUserName(newUserNameToLogin);
            String newPasswordToLogin=userDatas.get(5);
            login.enterPassWord(newPasswordToLogin);
            HomePage homePage=login.clickOnLoginButtonElement();
            String actualTextOfAddedUser=homePage.getTextNewlyAddedUserName();
            String expectedTextOfAddedUser=firstName+" " +lastName;
            Assert.assertEquals(actualTextOfAddedUser,expectedTextOfAddedUser,Messages.NEW_USER_ADDED_FAILED);

        }

    }