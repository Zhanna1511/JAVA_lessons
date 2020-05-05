package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm();
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}
