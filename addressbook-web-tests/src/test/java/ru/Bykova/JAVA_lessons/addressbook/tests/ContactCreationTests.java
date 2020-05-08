package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.Bykova.JAVA_lessons.addressbook.model.ContactData;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;

public class ContactCreationTests extends TestBase {
    private WebDriver wd;

    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForms(new ContactData("Gheorghe", "Alan", "Smith", "Nicky", "Tester", "Kontur", "Leninskiy avenu,168", "7-09-46", "8-924-345-23-34", "345-45-35", "234-45-23", "Email1@mail.ru", "Email2@bk.ru", "Email3@gmail.ru", "vk.com", "12", "March", "1995", "11", "June", "2001", "SPb, Nevsky avenu", "345-56-34", "Fish seller", "test1"), true);
        // app.getContactHelper().chooseAvatar("\\img\\1559798617_1.jpg");
        app.getContactHelper().chooseGroup("test1");
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }
}
