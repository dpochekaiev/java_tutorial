package com.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class HelperBase {
    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        if ((text != "") && text != null) {
            click(locator);
            String existingText = driver.findElement(locator).getAttribute("value");
            if (!existingText.equals(text)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    protected void attach(By locator, File file) {
        if (file != null) {
            driver.findElement(locator).sendKeys(file.getAbsolutePath());
        }
    }

    protected void selectDropdownValue(By locator, String dropdownValue) {
        if ((dropdownValue != "") && dropdownValue != null){
            driver.findElement(locator).click();
            Select dropDown = new Select(driver.findElement(locator));
            String selectedValue = dropDown.getFirstSelectedOption().getAttribute("text");
            if (!selectedValue.equals(dropdownValue)) {
                dropDown.selectByVisibleText(dropdownValue);
            }
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
