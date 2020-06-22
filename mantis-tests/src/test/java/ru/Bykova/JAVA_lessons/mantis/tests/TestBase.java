package ru.Bykova.JAVA_lessons.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.Bykova.JAVA_lessons.mantis.appmanager.ApplicationManager;

import java.io.File;

public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
        app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.ftp().restore("config_inc.php.bak", "config_inc.php");
        app.stop();
    }
    //public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
        //if (isIssueOpen(issueId)) {
            //throw new SkipException("Ignored because of issue " + issueId);
        //}
    //}

    //public boolean isIssueOpen(int issueId) throws MalformedURLException, ServiceException, RemoteException {
        //MantisConnectPortType mc = app.soap().getMantisConnect();
        //IssueData issue = mc.mc_issue_get(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"), BigInteger.valueOf(issueId));
        //return  (issue.getResolution().getName().equals("open") || issue.getResolution().getName().equals("reopen"));
    //}

}