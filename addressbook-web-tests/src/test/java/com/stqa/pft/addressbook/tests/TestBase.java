package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import org.openqa.selenium.remote.BrowserType;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    //Logger logger = LoggerFactory.getLogger(TestBase.class);

    static String testBrowser = System.getProperty("browser", BrowserType.CHROME);

//    static String testBrowser = BrowserType.CHROME;    // Chrome
//    static String testBrowser = BrowserType.FIREFOX;   // FireFox
//    static String testBrowser = BrowserType.EDGE;      // Edge
//    static String testBrowser = BrowserType.IE;      // Internet Explorer

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

//    @BeforeMethod (alwaysRun = true)
//    public void logTestStart(Method method, Object[] parameters) {
//        logger.info("================================================================================");
//        logger.info("Start test " + method.getName() + " with parameters " + Arrays.asList(parameters));
//    }
//
//    @AfterMethod
//    public void logTestFinish(Method method) {
//        logger.info("Test passed: " + method.getName());
//    }

}
