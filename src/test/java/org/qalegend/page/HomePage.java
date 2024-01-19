package org.qalegend.page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.constants.Constants;
import org.qalegend.utilities.WebElementUtility;

import java.util.ArrayList;

import static org.qalegend.utilities.ExcelUtility.readData;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class='dropdown-toggle']//span[text()='admin KL']")
    WebElement userLoggedAccount;
    @FindBy(xpath = "/html/body/div[2]/header/nav/div/div/strong")
    WebElement loginDateElement;

    @FindBy(xpath = "/html/body/div[2]/aside/section/ul/li[2]/a/span[2]/i")
    WebElement userManagementOptionField;

    @FindBy(xpath = "/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/span")
    WebElement usersOptionField;


    public String getTitle() {
        return driver.getTitle();
    }
    public String getUserLoggedAccount() {
        String username = WebElementUtility.getTextFromElement(userLoggedAccount);
        return username;
    }
    public String getLoginDate() {
        String loginDate=WebElementUtility.getTextFromElement(loginDateElement);
        return loginDate;
    }

    public UserManagementPage clickOnUserManagement() {
        WebElementUtility.clickOnElement(userManagementOptionField);
        return new UserManagementPage(driver);
    }
    public UsersPage clickOnUsersOption() {
        WebElementUtility.clickOnElement(usersOptionField);
        return new UsersPage(driver);
    }
    ;


}
