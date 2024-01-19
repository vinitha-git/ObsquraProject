package org.qalegend.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtility;

public class AddUsersPage {
    WebDriver driver;

    public AddUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='treeview']//span[@class='title']")
    WebElement userManagementField;

    public String getTitle() {
        return driver.getTitle();
    }
    public UserManagementPage clickOnUsersManagement() {
        Actions action=new Actions(driver);
        action.moveToElement(userManagementField).build().perform();
        return new UserManagementPage(driver);
    }

}