package com.stqa.pft.addressbook.appmanager;

import com.stqa.pft.addressbook.model.AccountMap;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    protected WebDriver driver;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public void init() {
        driver = new FirefoxDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook/group.php");

        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);

        sessionHelper.login("admin", "secret");
    }


    public void fillAccountForm(AccountMap accountMap) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(accountMap.getFirst());
        driver.findElement(By.name("middlename")).click();
        driver.findElement(By.name("middlename")).clear();
        driver.findElement(By.name("middlename")).sendKeys(accountMap.getMiddleName());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(accountMap.getSurname());
        driver.findElement(By.name("company")).click();
        driver.findElement(By.name("company")).clear();
        driver.findElement(By.name("company")).sendKeys(accountMap.getCompany());
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(accountMap.getAddress());
        driver.findElement(By.name("theform")).click();
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).clear();
        driver.findElement(By.name("home")).sendKeys(accountMap.getHomePhoneNumber());
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(accountMap.getEmailFirst());
        driver.findElement(By.name("bday")).click();
        new Select(driver.findElement(By.name("bday"))).selectByVisibleText(accountMap.getDayOfBirth());
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[3]")).click();
        driver.findElement(By.name("bmonth")).click();
        new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(accountMap.getMonthOfBirth());
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[35]")).click();
        driver.findElement(By.name("byear")).click();
        driver.findElement(By.name("byear")).clear();
        driver.findElement(By.name("byear")).sendKeys(accountMap.getYearOfBirth());
        driver.findElement(By.name("theform")).click();

    }

    public void submitAccountCreation() {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]")).click();
     //   driver.findElement(By.id("content")).click();
    }

    public void initAccountCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
