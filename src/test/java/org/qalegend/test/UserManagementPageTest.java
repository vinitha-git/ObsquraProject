package org.qalegend.test;

import org.qalegend.automationcore.Base;
import org.qalegend.constants.Constants;
import org.qalegend.page.HomePage;
import org.qalegend.page.LoginPage;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.qalegend.utilities.ExcelUtility.readData;

public class UserManagementPageTest extends Base {
    @Test
    public void verifyUserManagementOptions() {
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String username = data.get(1);
        login.enterUserName(username);
        String password = data.get(2);
        login.enterPassWord(password);
        HomePage home = login.clickOnLoginButtonElement();
    }
}