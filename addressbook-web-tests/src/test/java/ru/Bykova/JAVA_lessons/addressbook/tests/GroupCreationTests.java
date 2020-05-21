package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.addressbook.model.GroupData;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;

import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();//перейти на стр со списком групп
        Set<GroupData> before = app.group().all();//список ДО равен..
        GroupData group = new GroupData().withName("test2");//созд нов объкт типа групп дэйт с им тест2
        app.group().create(group);
        Set<GroupData> after = app.group().all();//новый список
        Assert.assertEquals(after.size(), before.size() +1);//размер списка после модификации равен размеру списка До+1

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());//новой доб.группе присваиваем ИД,где выч-ся максим.значение ИД
        before.add(group);
        Assert.assertEquals(before, after);
    }

}
