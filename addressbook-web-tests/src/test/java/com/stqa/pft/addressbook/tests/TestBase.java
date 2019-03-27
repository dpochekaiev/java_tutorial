package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

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
