package org.qalegend.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WaitUtility;
import org.qalegend.utilities.WebElementUtility;

public class AddUsersPage {
    WebDriver driver;

    public AddUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='treeview']//span[@class='title']")
    WebElement userManagementField;

     public UserManagementPage clickOnUsersManagement() {
        Actions action=new Actions(driver);
        action.moveToElement(userManagementField).build().perform();
        return new UserManagementPage(driver);
    }
    @FindBy(id="first_name")
    WebElement firstNameField;

    @FindBy(id="last_name")
    WebElement lastNameField;

    @FindBy(id="email")
    WebElement emailField;

    @FindBy(id="username")
    WebElement userNameField;

    @FindBy(id="password")
    WebElement passsWordField;

    @FindBy(id="confirm_password")
    WebElement confirmPassWordField;

    @FindBy(id="submit_user_button")
    WebElement saveButtonField;

    public String getTitle() {
        return driver.getTitle();
    }

    public void enterFirstName(String firstName){
        WebElementUtility.enterValue(firstNameField,firstName);
    }
    public void enterLastName(String lastName) {
        WebElementUtility.enterValue(lastNameField,lastName);
    }
    public void enterEmailId(String emailID) {
        WebElementUtility.enterValue(emailField,emailID);
    }
    public void enterUserName(String userName) {
        WebElementUtility.enterValue(userNameField,userName);
    }
    public void enterPassWord(String passWord) {
        WebElementUtility.enterValue(passsWordField,passWord);
    }
    public  void enterconfirmPassWord(String confirmPassword) {
        WebElementUtility.enterValue(confirmPassWordField,confirmPassword);
    }
    public UsersPage clickOnSaveButton() {
        WebElementUtility.clickOnElement(saveButtonField);
        WaitUtility.pageLoadWait(driver,10);
        driver.navigate().back();
        return new UsersPage(driver);

    }


}