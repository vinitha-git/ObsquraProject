package org.qalegend.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtility;

public class UsersPage {
    WebDriver driver;
    public UsersPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement addButton;
    public AddUsersPage clickOnAddButton() {
        WebElementUtility.clickOnElement(addButton);
        return new AddUsersPage(driver);
    }
}
