package ru.Bykova.JAVA_lessons.mantis.tests;

import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.mantis.appmanager.HttpSession;
import java.io.IOException;
import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase {

    @Test
    public void testLogin() throws IOException {
        HttpSession session = app.newSession();
        assertTrue(session.login("administrator", "root"));//проверка,что поль-ль залогинился и на стр входа появился нужный текст
        assertTrue(session.isLoggedInAs("administrator"));
    }
}