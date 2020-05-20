package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.addressbook.model.GroupData;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();//переход на нужную стр.
        if (app.group().list().size() == 0) {//проверка предусловия, и если оно не вып.-подготовка состояния
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {
        List<GroupData> before = app.group().list();
        int index = before.size() -1;
        GroupData group = new GroupData().withId(before.get(index).getId()).withName("test1").withHeader("test2").withFooter("test3");
        app.group().modify(index, group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = (g1,g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}
