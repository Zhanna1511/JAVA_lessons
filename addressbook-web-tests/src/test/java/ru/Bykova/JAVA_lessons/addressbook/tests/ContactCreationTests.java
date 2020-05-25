package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.addressbook.model.ContactData;
import ru.Bykova.JAVA_lessons.addressbook.model.Contacts;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/1559798617_1.jpg");
        ContactData contact = new ContactData().withFirstName("Gheorghe").withMiddleName("Alan").withLastName("Smith").withPhoto(photo).withNickName(
                "Nicky").withPosition("Tester").withCompany("Kontur").withCompanyAddress("Leninskiy avenu,168").withHomePhone(
                "7-09-46").withMobilePhone("8-924-345-23-34").withWorkPhone("345-45-35").withFax("234-45-23").withEmail(
                "Email1@mail.ru").withEmail2("Email2@bk.ru").withEmail3("Email3@gmail.ru").withHomepage(
                "vk.com").withBday("12").withBmonth("March").withByear("1995").withAday("11").withAmonth(
                "June").withAyear("2001").withGroup("test1").withHomeAddress(
                "SPb, Nevsky avenu").withHomePhone2("345-56-34").withPosition("Fish seller");
        app.contact().create(contact, true);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() +1));

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test (enabled = false)//всп тест для опр-я текущ дир-ии
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());//опр абс дир-ию
        File photo = new File("src/test/resources/1559798617_1.jpg");//убедимся,что объект сущ-ет
        System.out.println(photo.getAbsolutePath());//выведем на конс.полн.путь к этому файлу
        System.out.println(photo.exists()); //проверим,что файл сущ-т

    }

    @Test
    public void testBadContactCreation() throws Exception {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstName("Gho'").withMiddleName("Alan").withLastName("Smith").withNickName(
                "Nicky").withBday("12").withBmonth("March").withByear("1995").withAday("11").withAmonth(
                "June").withAyear("2001").withGroup("test1");
        app.contact().create(contact, true);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();

        assertThat(after, equalTo(before));
    }
}