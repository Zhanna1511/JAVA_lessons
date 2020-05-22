package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.addressbook.model.ContactData;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;

public class ContactPhoneTests extends TestBase {

    @Test
    public void testContactPhones() {
        app.goTo().homePage();//переход на гл стр прил-я
        ContactData contact = app.contact().all().iterator().next();//загруж.список мн-ва конт
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    }
}
