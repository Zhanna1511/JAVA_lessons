package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;
import ru.Bykova.JAVA_lessons.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Gheorghe", "Alan", "Smith", "Nicky", "Tester", "Kontur", "Leninskiy avenu,168", "7-09-46", "8-924-345-23-34", "345-45-35", "234-45-23", "Email1@mail.ru", "Email2@bk.ru", "Email3@gmail.ru", "vk.com", "12", "March", "1995", "11", "June", "2001","test1", "SPb, Nevsky avenu", "345-56-34", "Fish seller"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.wd.switchTo().alert().accept();
    }
}
