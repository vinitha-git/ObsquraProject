package org.qalegend.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AppUtility {
    public static Boolean selectValueFromRadioButton(List<WebElement> values, String valueToSelect)
    {
        boolean status = false;
        for (WebElement value : values) {
            String text = value.getText();
            if (text.equals(valueToSelect)) {
                value.click();
                status=WebElementUtility.isElementSelected(value);
                break;

            }
        }
        return status;
    }
    public static List<String> getMenuOption(List<WebElement> options) {
        List<String> menuValues = new ArrayList<>();
        for (WebElement option : options) {
            String value = option.getText();
            menuValues.add(value);
        }
        return menuValues;
    }
}
