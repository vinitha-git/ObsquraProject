package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.AppUtility;

import java.util.List;

public class UserManagementPage {
    WebDriver driver;

    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
    @FindBy(xpath="//input[@type='search']")
    WebElement searchField;


    @FindBy(xpath="//ul[@class='treeview-menu menu-open']//span[@class='title']")
    List<WebElement> userManagementMenuOptions;

    public List<String> getUserManagementOptions() {
        return AppUtility.getMenuOption(userManagementMenuOptions);
    }

}
