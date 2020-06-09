package ru.Bykova.JAVA_lessons.mantis.appmanager;

import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;
import ru.Bykova.JAVA_lessons.mantis.model.MailMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MailHelper {
    private ApplicationManager app;
    private final Wiser wiser;

    public MailHelper(ApplicationManager app) {
        this.app = app;
        wiser = new Wiser();
    }

    public List<MailMessage> waitForMail(int count, long timeout) throws MessagingException, IOException {
        long start = System.currentTimeMillis();//запоминаем текущ время
        while (System.currentTimeMillis() < start + timeout) {//проверка,что новое текущ время не превыш момент старта + таймаут
            if (wiser.getMessages().size() >= count) {//если почты пришло дост много,то ожидание можно прекращать
                return wiser.getMessages().stream().map((m) -> toModelMail(m)).collect(Collectors.toList());//преобразование реальных объектов в модельные,когда почты пришло очень много
            }
            try {//если почты слишком мало,то проскакиваем сюда
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        throw new Error("No mail");
    }

    public static MailMessage toModelMail(WiserMessage m) {//преобр-е реальных объ-в в модельные
        try {
            MimeMessage mm = m.getMimeMessage();//берем реальный объект
            return new MailMessage(mm.getAllRecipients()[0].toString(), (String) mm.getContent());//берем список получателей и ост только первого из них
        } catch (MessagingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void start() {wiser.start();}

    public  void stop() {wiser.stop();}

}