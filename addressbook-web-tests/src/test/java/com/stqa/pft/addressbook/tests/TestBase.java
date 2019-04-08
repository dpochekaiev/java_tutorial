package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.remote.BrowserType;

public class TestBase {

//    String testBrowser = BrowserType.CHROME;    // Chrome
//    String testBrowser = BrowserType.FIREFOX;   // FireFox
//    String testBrowser = BrowserType.EDGE;      // Edge
    String testBrowser = BrowserType.IE;      // Internet Explorer

    protected final ApplicationManager app = new ApplicationManager(testBrowser);

    //@BeforeClass(alwaysRun = true)
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    //@AfterClass(alwaysRun = true)
    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
