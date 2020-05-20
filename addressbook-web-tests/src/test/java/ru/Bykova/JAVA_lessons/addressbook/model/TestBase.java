package ru.Bykova.JAVA_lessons.addressbook.model;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.Bykova.JAVA_lessons.addressbook.appmanager.ApplicationManager;
import static org.openqa.selenium.remote.BrowserType.CHROME;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(CHROME);

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
