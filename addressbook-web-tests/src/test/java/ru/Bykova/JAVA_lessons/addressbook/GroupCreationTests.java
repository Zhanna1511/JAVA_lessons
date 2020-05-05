package ru.Bykova.JAVA_lessons.addressbook;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm();
        submitGroupCreation();
        returnToGroupPage();
    }

}
