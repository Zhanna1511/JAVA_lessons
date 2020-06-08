package ru.Bykova.JAVA_lessons.mantis.appmanager;

import org.openqa.selenium.WebDriver;

public class RegistrationHelper {
    private  final ApplicationManager app;
    private WebDriver wd;


    public RegistrationHelper(ApplicationManager app) {
        this.app = app;
        wd = app.getDriver();//метод инициализирует драйвер в момент первого обращения
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
    }
}