package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.addressbook.model.ContactData;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void  ensurePreconditions() {
        app.goTo().homePage();//переход на гл стр прил-я
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("Gheorghe").withLastName("Smith").withCompanyAddress(
                    "Leninskiy avenu,168").withHomePhone("7-09-46").withMobilePhone("8-924-345-23-34").withWorkPhone(
                    "345-45-35").withFax("234-45-23").withEmail("Email1@mail.ru").withGroup("test1"), true);
        }
    }

    @Test
    public void testContactPhones() {
        ContactData contact = app.contact().all().iterator().next();//загруж.список мн-ва конт
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }
    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(), contact.getHomePhone2())
                .stream().filter((s) -> !s.equals(""))//отфильр пуст строки
                .map(ContactPhoneTests::cleaned)//ко всем тел применяем функц отчистки-чистим ненужные символы
                .collect(Collectors.joining("\n"));//из очищ тел собираем 1 большую строкуи получ рез-т сравниваем с тем,кот был получен с гл стр прил-я
    }

    public static String cleaned(String phone) {//замена "плохих" символов в ном тел
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }
}
