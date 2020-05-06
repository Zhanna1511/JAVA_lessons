package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.wd.switchTo().alert().accept();
    }
}
