package ru.Bykova.JAVA_lessons.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.mantis.model.MailMessage;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testRegistration() throws IOException, MessagingException {
        long now = System.currentTimeMillis();//возвр комп-е время в млсек
        String email = String.format("user%s@localhost.localdomain", now);
        String user = String.format("user%s", now);
        String password = "password";
        app.registration().start(user, email);
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);//Ожидание письма
        String confirmationLink = findConfirmationLink(mailMessages, email);//присв ссылку в переменную
        app.registration().finish(confirmationLink, password);//заверш регистр-ю
        assertTrue(app.newSession().login(user, password));//проверка,что поль-ль вх

    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();//найти письмо,кот отпр на нужный адрес
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();//регулярное выражение
        return regex.getText(mailMessage.text);//возвр тот кусок текста,кот соотв-т регуляр выр-ю
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}