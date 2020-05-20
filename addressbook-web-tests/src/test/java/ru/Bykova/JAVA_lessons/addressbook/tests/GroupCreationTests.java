package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.addressbook.model.GroupData;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;
import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();//перейти на стр со списком групп
        List<GroupData> before = app.group().list();//список ДО равен..
        GroupData group = new GroupData("test2",null,null);//созд тестовые данные
        app.group().create(group);
        List<GroupData> after = app.group().list();//новый список
        Assert.assertEquals(after.size(), before.size() +1);//размер списка после модификации равен размеру списка До+1

        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
