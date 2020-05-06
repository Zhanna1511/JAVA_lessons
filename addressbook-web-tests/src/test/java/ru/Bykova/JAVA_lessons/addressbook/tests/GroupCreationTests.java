package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.annotations.*;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.fillGroupForm();
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }

}
