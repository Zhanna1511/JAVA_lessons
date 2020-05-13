package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.addressbook.model.GroupData;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();//выч кол-во групп ДО добавления
        app.getGroupHelper().createGroup(new GroupData("test1",null,null));
        int after = app.getGroupHelper().getGroupCount();//выч кол-во групп ПОСЛЕ добавления
        Assert.assertEquals(after, before +1);//кол-во групп,доб.ДО должно совп.с кол-вом групп,доб.ПОСЛЕ,увел-х на ед.

    }

}
