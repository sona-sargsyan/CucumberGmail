package com.cucumber.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementHighlighter {

    public static void highlightWebElement(WebDriver driver, WebElement element) {
        String backgroundColor = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor ='" + "yellow" + "'", element);
        js.executeScript("arguments[0].style.backgroundColor = '" + backgroundColor + "'", element);
    }
}
