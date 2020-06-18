package ru.Bykova.JAVA_lessons.mantis.appmanager;

import org.openqa.selenium.By;

public class RegistrationHelper extends HelperBase {

    public RegistrationHelper(ApplicationManager app) {
        super(app);
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        type(By.name("username"), username);
        type(By.name("email"), email);
        click(By.cssSelector("input[value='Signup']"));
    }
    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);//проходим по ссылке
        type(By.name("password"), password);//заполн 2 поля
        type(By.name("password_confirm"), password);//повтор пароля
        click(By.cssSelector("button[type='submit']"));
    }

    public void login(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), username);
        click(By.cssSelector("input[value='Login']"));
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Login']"));
    }

}