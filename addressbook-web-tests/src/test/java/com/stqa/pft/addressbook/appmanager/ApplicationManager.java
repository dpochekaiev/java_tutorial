package com.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    private final Properties properties;

    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private DbHelper dbHelper;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    protected WebDriver driver;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        dbHelper = new DbHelper();

        switch (browser) {
            case BrowserType.FIREFOX:
                driver = new FirefoxDriver();
                System.out.println("Using FIREFOX webdiver ID.");
                break;
            case BrowserType.CHROME:
                driver = new ChromeDriver();
                System.out.println("Using CHROME webdiver ID.");
                break;
            case BrowserType.EDGE:
                driver = new EdgeDriver();
                System.out.println("Using EDGE webdiver ID.");
                break;
            case BrowserType.IE:
                driver = new InternetExplorerDriver();
                System.out.println("Using IE webdiver ID.");
                break;
            default:
                System.out.println("Unknown webdiver ID.");
                break;
        }

//        if (browser.equals(BrowserType.FIREFOX)) {
//            driver = new FirefoxDriver();
//        } else if (browser.equals(BrowserType.CHROME)) {
//            driver = new ChromeDriver();
//        } else if (browser.equals(BrowserType.EDGE)) {
//            driver = new EdgeDriver();
//        } else if (browser.equals(BrowserType.IE)) {
//            driver = new InternetExplorerDriver();
//        }

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);  // the default value is '30'
//        driver.get("http://localhost/addressbook");
        driver.get(properties.getProperty("web.baseUrl"));

        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        contactHelper = new ContactHelper(driver);

//        sessionHelper.login("admin", "secret");
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
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

    /**
     * Method returns the group helper to have an access to all helper's methods
     */
    public GroupHelper group() {
        return groupHelper;
    }

    /**
     * Method returns the navigation helper to have an access to all helper's methods
     */
    public NavigationHelper goTo() {
        return navigationHelper;
    }

    /**
     * Method returns the contact helper to have an access to all helper's methods
     */
    public ContactHelper contact() {
        return contactHelper;
    }

    /**
     * Method returns the data base helper
     * to have an access to the application database through the direct requests
     */
    public DbHelper db() {
        return dbHelper;
    }

}
