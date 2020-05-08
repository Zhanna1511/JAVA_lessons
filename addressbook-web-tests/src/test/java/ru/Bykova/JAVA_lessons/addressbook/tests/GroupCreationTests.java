package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.annotations.*;
import ru.Bykova.JAVA_lessons.addressbook.model.GroupData;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test1",null,null));
    }

}
