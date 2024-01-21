package org.qalegend.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WaitUtility;
import org.qalegend.utilities.WebElementUtility;

public class UsersPage {
    WebDriver driver;

    public UsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement addButtonField;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;

    @FindBy(xpath = "//table//tr//td[4][contains(text(), 'shifana123@gmail.com')]")
    WebElement actualMailIdOfNewlyAddedUser;

    public AddUsersPage clickOnAddButton() {
        WebElementUtility.clickOnElement(addButtonField);
        return new AddUsersPage(driver);
    }

    public void enterTextOnSearchField(String emailId) {
        if (searchField.isEnabled() && searchField.isDisplayed()) {
            searchField.click();
        } else {
            //System.out.println("Element is not clickable");
        }
        WebElementUtility.enterValue(searchField, emailId);
        WaitUtility.pageLoadWait(driver, 10);
    }

    public String getTextOfMailID() {
        String emailText=WebElementUtility.getTextFromElement(actualMailIdOfNewlyAddedUser);
        return emailText;
    }
}
