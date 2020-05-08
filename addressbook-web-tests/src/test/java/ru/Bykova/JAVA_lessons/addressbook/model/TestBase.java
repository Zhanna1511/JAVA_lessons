package ru.Bykova.JAVA_lessons.addressbook.model;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.Bykova.JAVA_lessons.addressbook.appmanager.ApplicationManager;

import static org.openqa.selenium.remote.BrowserType.*;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(CHROME);

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
