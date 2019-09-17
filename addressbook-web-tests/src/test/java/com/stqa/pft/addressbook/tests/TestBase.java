package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    static String testBrowser = BrowserType.CHROME;    // Chrome
//    String testBrowser = BrowserType.FIREFOX;   // FireFox
//    String testBrowser = BrowserType.EDGE;      // Edge
//    String testBrowser = BrowserType.IE;      // Internet Explorer

    protected static final ApplicationManager app = new ApplicationManager(testBrowser);

    //@BeforeClass(alwaysRun = true)
    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    //@AfterClass(alwaysRun = true)
    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
